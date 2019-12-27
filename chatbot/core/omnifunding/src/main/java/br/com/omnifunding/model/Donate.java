package br.com.omnifunding.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.annotation.Immutable;

@Immutable
@Entity(name = "view_doadores")
public class Donate {

	@Id
	@Column(name = "ID_DOADOR")
	private Long id;

	@Column(name = "SEXO")
	private String sexo;

	@Column(name = "IDADE")
	private String idade;

	@Column(name = "UF")
	private String uf;

	@Column(name = "DATA")
	private Calendar data;

	@Column(name = "TIPOS")
	private String tipos;

	@Column(name = "ID_OPERADOR")
	private Long idOperador;

	@Column(name = "ID_EVENTO")
	private Long idEvento;

	@Column(name = "VALOR")
	private BigDecimal valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getTipos() {
		return tipos;
	}

	public void setTipos(String tipos) {
		this.tipos = tipos;
	}

	public Long getIdOperador() {
		return idOperador;
	}

	public void setIdOperador(Long idOperador) {
		this.idOperador = idOperador;
	}

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
