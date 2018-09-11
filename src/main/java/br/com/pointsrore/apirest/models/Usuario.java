package br.com.pointsrore.apirest.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	private String sobrenome;
	private String cpf;
	private Integer credito;
	private String email;
	private String login;
	private String senha;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_meus_pontos")
	private List<MeusPontos> meusPontos;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_usuario_vendedor")
	private List<Venda> idUsuarioVendedor;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_usuario_comprador")
	private List<Venda> idUsuarioComprador;
	
	public Usuario(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getCredito() {
		return credito;
	}

	public void setCredito(Integer credito) {
		this.credito = credito;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<MeusPontos> getMeusPontos() {
		return meusPontos;
	}

	public void setMeusPontos(List<MeusPontos> meusPontos) {
		this.meusPontos = meusPontos;
	}

	public List<Venda> getIdUsuarioVendedor() {
		return idUsuarioVendedor;
	}

	public void setIdUsuarioVendedor(List<Venda> idUsuarioVendedor) {
		this.idUsuarioVendedor = idUsuarioVendedor;
	}

	public List<Venda> getIdUsuarioComprador() {
		return idUsuarioComprador;
	}

	public void setIdUsuarioComprador(List<Venda> idUsuarioComprador) {
		this.idUsuarioComprador = idUsuarioComprador;
	}
	
}
