package br.com.rasaframework.incoming.model;

import com.google.gson.annotations.SerializedName;

public class StringEntityValue extends RasaEntityValue {

	@SerializedName("value")
	private String stringValue;

	public String getStringValue() {
		return stringValue;
	}

	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

}
