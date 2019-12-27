package br.com.rasaframework.incoming.model;

import com.google.gson.annotations.SerializedName;

public abstract class RasaEntityValue {
	@SerializedName("value")
	private String stringValue;

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}
}
