package br.com.pointsrore.apirest.resources;

import java.util.ArrayList;
import java.util.List;

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
		try {
			this.usuarioRepository.save(jsonUsuario);
			List<MeusPontos> listaDosPontos = this.getMeusPontosDefault(jsonUsuario);
			MeusPontos tam = listaDosPontos.get(0);
			MeusPontos gol = listaDosPontos.get(1);
			this.meusPontosRepository.save(tam);
			this.meusPontosRepository.save(gol);
			System.out.println(listaDosPontos);
			
		} catch (PersistenceException pe) {
			System.out.println("ocorreu um erro que foi: " + pe.getMessage());
		}
		List<MeusPontos> listaDosPontos = this.getMeusPontosDefault(jsonUsuario);
		
		return "usuario cadastrado com sucesso!!";
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
