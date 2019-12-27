package br.com.rasaframework.incoming.model;

import com.google.gson.annotations.SerializedName;

public class TimeEntityValue extends RasaEntityValue {

	@SerializedName("from")
	private String from;
	@SerializedName("to")
	private String to;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
