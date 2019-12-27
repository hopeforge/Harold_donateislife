package br.com.rasaframework.incoming.model;

import java.io.Serializable;
import java.util.List;

public class AdditionalInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String grain;
	private Object value;
	private List<Others> others;

	public String getGrain() {
		return grain;
	}

	public void setGrain(String grain) {
		this.grain = grain;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<Others> getOthers() {
		return others;
	}

	public void setOthers(List<Others> others) {
		this.others = others;
	}

}
