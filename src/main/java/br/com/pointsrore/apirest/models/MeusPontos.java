package br.com.pointsrore.apirest.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="meus_pontos")
public class MeusPontos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String tipoDePonto;
	private Integer quantidadeDePontos;
	
	@ManyToOne(targetEntity=Usuario.class)
	@JoinColumn(name="id_usuairio", referencedColumnName="id")
	private Usuario idUsuario;
	
	@OneToMany(targetEntity=Venda.class, mappedBy="idMeusPontos", cascade=CascadeType.ALL)
	private List<Venda> idVenda;
	
	public MeusPontos(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoDePonto() {
		return tipoDePonto;
	}

	public void setTipoDePonto(String tipoDePonto) {
		this.tipoDePonto = tipoDePonto;
	}

	public Integer getQuantidadeDePontos() {
		return quantidadeDePontos;
	}

	public void setQuantidadeDePontos(Integer quantidadeDePontos) {
		this.quantidadeDePontos = quantidadeDePontos;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<Venda> getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(List<Venda> idVenda) {
		this.idVenda = idVenda;
	}

}
