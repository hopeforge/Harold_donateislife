package br.com.omnifunding.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.annotation.Immutable;

@Immutable
@Entity(name = "view_grafico_um")
public class DashboardByValue implements Serializable {

	@Id
	@Column(name = "ANO")
	private Integer ano;

	@Column(name = "VALOR")
	private BigDecimal valor;

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
