package br.com.rasaframework.util;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class SkipDeserializationAnnotationExclusionStrategy implements ExclusionStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.gson.ExclusionStrategy#shouldSkipField(com.google.gson.
	 * FieldAttributes)
	 */
	public boolean shouldSkipField(FieldAttributes f) {
		return f.getAnnotation(SkipDeserialization.class) != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.gson.ExclusionStrategy#shouldSkipClass(java.lang.Class)
	 */
	public boolean shouldSkipClass(Class<?> clazz) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SkipDeserializationAnnotationExclusionStrategy []";
	}
}