package br.com.rasaframework.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import br.com.rasaframework.incoming.model.Entity;
import br.com.rasaframework.incoming.model.RasaEntityValue;
import br.com.rasaframework.incoming.model.StringEntityValue;
import br.com.rasaframework.incoming.model.TimeEntityValue;

public class EntityValueDeserializer implements JsonDeserializer<Entity> {

	private static Gson delegateGson;

	/**
	 * Instantiates a new AttachmentDeserializer.
	 */
	public EntityValueDeserializer() {
		GsonBuilder builder = new GsonBuilder();
		builder.addDeserializationExclusionStrategy(new SkipDeserializationAnnotationExclusionStrategy());
		delegateGson = builder.create();
	}

	public Entity deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {

		Entity entity = delegateGson.fromJson(json, Entity.class);
		JsonElement value = json.getAsJsonObject().get("value");
		RasaEntityValue rs;
		if (entity.getDuckling() != null && entity.getDuckling().equals("time")) {
			if (value.isJsonObject() && value.getAsJsonObject().get("from") != null) {
				rs = new TimeEntityValue();
				((TimeEntityValue) rs).setFrom(value.getAsJsonObject().get("from").toString());
				((TimeEntityValue) rs).setTo(value.getAsJsonObject().get("to").toString());
			} else {
				rs = new StringEntityValue();
				((StringEntityValue) rs).setStringValue(value.toString());
			}
		} else {
			rs = new StringEntityValue();
			((StringEntityValue) rs).setStringValue(value.toString());
		}
		entity.setValue(value.toString());
		return entity;
	}
}
