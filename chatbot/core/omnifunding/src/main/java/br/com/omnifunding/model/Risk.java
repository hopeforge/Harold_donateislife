package br.com.omnifunding.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.annotation.Immutable;

@Immutable
@Entity(name = "view_doadores_risco")
public class Risk implements Serializable {

	@Id
	@Column(name = "ID_DOADOR")
	private Long id;
	@Column(name = "SEXO")
	private String sexo;
	@Column(name = "IDADE")
	private Long idade;

	@Column(name = "UF")
	private String uf;

	@Column(name = "VALOR")
	private BigDecimal valor;

	@Column(name = "DATA")
	private Calendar data;

	@Column(name = "TIPO_EVENTO")
	private String tipo_evento;

	@Column(name = "TIPO_DOADOR")
	private String tipo_doador;

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

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
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

	public String getTipo_evento() {
		return tipo_evento;
	}

	public void setTipo_evento(String tipo_evento) {
		this.tipo_evento = tipo_evento;
	}

	public String getTipo_doador() {
		return tipo_doador;
	}

	public void setTipo_doador(String tipo_doador) {
		this.tipo_doador = tipo_doador;
	}

}
