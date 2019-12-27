package br.com.rasaframework.incoming.model;

import java.io.Serializable;
import java.util.Date;

public class Others implements Serializable {

	private static final long serialVersionUID = 1L;

	private String grain;
	private Date value;
	private Date from;
	private Date to;

	public String getGrain() {
		return grain;
	}

	public void setGrain(String grain) {
		this.grain = grain;
	}

	public Date getValue() {
		return value;
	}

	public void setValue(Date value) {
		this.value = value;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

}
