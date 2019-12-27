package br.com.rasaframework.incoming.model;

import java.io.Serializable;
import java.util.List;

/**
 * The Class Response.
 */
public class IntentResponse implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The text. */
	private String text;

	/** The entity. */
	private List<Entity> entities;

	/** The intent. */
	private Intent intent;

	/** The intent ranking. */
	private List<Intent> intent_ranking;

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text
	 *            the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the entity.
	 *
	 * @return the entity
	 */
	public List<Entity> getEntities() {
		return entities;
	}

	/**
	 * Sets the entity.
	 *
	 * @param entity
	 *            the new entity
	 */
	public void setEntities(List<Entity> entity) {
		this.entities = entity;
	}

	/**
	 * Gets the intent.
	 *
	 * @return the intent
	 */
	public Intent getIntent() {
		return intent;
	}

	/**
	 * Sets the intent.
	 *
	 * @param intent
	 *            the new intent
	 */
	public void setIntent(Intent intent) {
		this.intent = intent;
	}

	public List<Intent> getIntent_ranking() {
		return intent_ranking;
	}

	public void setIntent_ranking(List<Intent> intent_ranking) {
		this.intent_ranking = intent_ranking;
	}

//	public StringEntityValue searchForStringEntityValue(String value) {
//		// if (entityName instanceof JsonPrimitive) {
//		for (Entity ent : this.getEntities()) {
//			if (ent.getEntity().equals(value)) {
//				if (ent.getValue() instanceof StringEntityValue) {
//					return ((StringEntityValue) ent.getValue());
//				}
//			}
//		}
//		return null;
//	}
//
//	public RasaEntityValue searchForDucklingValue(String value) {
//		for (Entity ent : this.getEntities()) {
//			if (ent.getEntity().equals(value)) {
//				if (ent.getValue() instanceof TimeEntityValue && ent.getDuckling() != null) {
//					return ((TimeEntityValue) ent.getValue());
//				} else if (ent.getValue() instanceof StringEntityValue && ent.getDuckling() != null) {
//					return ((StringEntityValue) ent.getValue());
//				}
//			}
//		}
//		return null;
//	}

}
