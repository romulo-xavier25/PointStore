package br.com.pointsrore.apirest.resources;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pointsrore.apirest.models.MeusPontos;
import br.com.pointsrore.apirest.models.Usuario;
import br.com.pointsrore.apirest.repository.MeusPontosRepository;
import br.com.pointsrore.apirest.repository.UsuarioRepository;


@RestController
@RequestMapping(value="/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private MeusPontosRepository meusPontosRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("status")
	public String statusURL(){
		return "status ok!!";
	}
	
	@GetMapping("/listar")
	public List<Usuario> listaProdutos(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/listar/{id}")
	public Usuario listaProdutos(@PathVariable(value="id") int id){
		return this.usuarioRepository.findById(id);
	}
	
	@PostMapping("/cadastrar")
	public String cadastrarUsario(@RequestBody Usuario jsonUsuario){
		Boolean aprovadorDecadastro = vericarEmailNoBanco(jsonUsuario);

		if(aprovadorDecadastro == false){
			return "usuario nao pode ser cadastrado, email existente em nosso banco de dados";
		}
		
		jsonUsuario.setCredito(100);
		
		try {
			this.usuarioRepository.save(jsonUsuario);
			List<MeusPontos> listaDosPontos = this.getMeusPontosDefault(jsonUsuario);
			MeusPontos tam = listaDosPontos.get(0);
			MeusPontos gol = listaDosPontos.get(1);
			this.meusPontosRepository.save(tam);
			this.meusPontosRepository.save(gol);
		} catch (PersistenceException pe) {
			System.out.println("ocorreu um erro que foi: " + pe.getMessage());
		}
		return "usuario cadastrado com sucesso!!";
	}

	public Boolean vericarEmailNoBanco(Usuario user){
		Usuario usuario;
		try {
			usuario = (Usuario) this.entityManager.createQuery("SELECT user from Usuario user where user.email = :email")
					.setParameter("email", user.getEmail()).getSingleResult();
			if(usuario.getEmail().length() > 0){
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return true;
	}
	
	public List<MeusPontos> getMeusPontosDefault(Usuario jsonUsuario){
		MeusPontos tam = new MeusPontos();
		tam.setTipoDePonto("tam");
		tam.setIdUsuario(jsonUsuario);
		tam.setQuantidadeDePontos(0);
		
		MeusPontos gol = new MeusPontos();
		gol.setTipoDePonto("gol");
		gol.setIdUsuario(jsonUsuario);
		gol.setQuantidadeDePontos(0);
		
		List<MeusPontos> listaDePontos = new ArrayList<MeusPontos>();
		listaDePontos.add(tam);
		listaDePontos.add(gol);
		
		return listaDePontos;
	}

}
