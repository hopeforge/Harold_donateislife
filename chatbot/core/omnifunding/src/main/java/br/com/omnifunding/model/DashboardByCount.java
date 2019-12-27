package br.com.omnifunding.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.annotation.Immutable;

@Immutable
@Entity(name = "view_grafico_dois")
public class DashboardByCount implements Serializable {

	@Id
	@Column(name = "TIPO")
	private String tipo;

	@Column(name = "QNT")
	private Long qnt;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getQnt() {
		return qnt;
	}

	public void setQnt(Long qnt) {
		this.qnt = qnt;
	}

}
