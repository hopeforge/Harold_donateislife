package br.com.omnifunding.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Component
public class RasaRepository {

	@Value("${rasa.url}")
	static final String URL_RASA = "http://localhost:5000?parse=";

	RestTemplate restTemplate = new RestTemplate();

	public String findIntent(String text) {

		final String response = restTemplate.getForObject(URL_RASA + text, String.class);

		JsonObject obj = (new Gson()).fromJson(response, JsonObject.class);

		return obj.get("intent").getAsString();

	}

}
