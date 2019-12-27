package br.com.omnifunding.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.omnifunding.model.Profiles;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/twitter")
public class SocialCrawllerController {

	static final String URL_API = "http://localhost:8081/";

	RestTemplate restTemplate = new RestTemplate();

	@GetMapping("/search")
	public List<Profiles> searchLeads(@RequestParam("messages") String messages) {

		final String response = restTemplate.getForObject(URL_API + "crawller?hashtags=" + messages, String.class);

		final Type listType = new TypeToken<ArrayList<Profiles>>() {}.getType();
		
		return (new Gson()).fromJson(response, listType);
	}

	@RequestMapping("/sendDirect")
	public String sendDirectMessage(@RequestParam("id") String id, @RequestParam("text") String text) {

		final String response = restTemplate.getForObject(URL_API + "sendDirect?id=" + id, String.class);

		return response;
		
	}

}
