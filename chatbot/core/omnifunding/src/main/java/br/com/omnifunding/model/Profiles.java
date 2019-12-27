package br.com.omnifunding.model;

import br.com.omnifunding.enums.EOrigin;
import lombok.Data;

@Data
public class Profiles {

	private String user_id;
	private EOrigin origin;
	private String search_phrase;
	private String text;
	private String screen_name;
	private String created_at;
	private String retweet_count;
	private String favorite_count;
	private String friends_count;
	private String followers_count;
	private String user_name;
	private String user_location;
	private String user_description;
	private String probability;
}
