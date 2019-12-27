
package br.com.rasaframework.incoming.model;

import java.io.Serializable;

/**
 * The Class Entity.
 */
public class Entity implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private String duckling;

	private String start;

	private String end;

	private String value;

	private String entity;

	private String extractor;

	private AdditionalInfo additional_info;

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getDuckling() {
		return duckling;
	}

	public void setDuckling(String duckling) {
		this.duckling = duckling;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getExtractor() {
		return extractor;
	}

	public void setExtractor(String extractor) {
		this.extractor = extractor;
	}

	public AdditionalInfo getAdditionalInfo() {
		return additional_info;
	}

	public void setAdditionalInfo(AdditionalInfo additionalInfo) {
		this.additional_info = additionalInfo;
	}

}
