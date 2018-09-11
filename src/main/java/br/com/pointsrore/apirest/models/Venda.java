package br.com.pointsrore.apirest.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendas")
public class Venda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String titulo;
	private Integer valor;
	
	@Column(name="id_usuario_vendedor")
	private Integer idUsuarioVendedor;
	
	@Column(name="id_usuario_comprador")
	private Integer idUsuarioComprador;
	
	@Column(name="id_meus_pontos")
	private Integer idMeusPontos;
	
	private String status;
	private Integer quantidadePontos;
	
	public Venda(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Integer getIdUsuarioVendedor() {
		return idUsuarioVendedor;
	}

	public void setIdUsuarioVendedor(Integer idUsuarioVendedor) {
		this.idUsuarioVendedor = idUsuarioVendedor;
	}

	public Integer getIdUsuarioComprador() {
		return idUsuarioComprador;
	}

	public void setIdUsuarioComprador(Integer idUsuarioComprador) {
		this.idUsuarioComprador = idUsuarioComprador;
	}

	public Integer getIdMeusPontos() {
		return idMeusPontos;
	}

	public void setIdMeusPontos(Integer idMeusPontos) {
		this.idMeusPontos = idMeusPontos;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getQuantidadePontos() {
		return quantidadePontos;
	}

	public void setQuantidadePontos(Integer quantidadePontos) {
		this.quantidadePontos = quantidadePontos;
	}

}
