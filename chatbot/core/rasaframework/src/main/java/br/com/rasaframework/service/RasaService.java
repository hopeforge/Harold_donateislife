package br.com.rasaframework.service;

import java.io.File;
import java.io.FileReader;
import java.net.URISyntaxException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.rasaframework.incoming.model.IntentResponse;
import br.com.rasaframework.incoming.model.TrainingResponse;
import br.com.rasaframework.outgoing.model.DataQuery;
import br.com.rasaframework.util.JsonUtils;
import br.com.rasaframework.util.NetworkUtils;

/**
 * The Class RasaService.
 */
public class RasaService {

	/**
	 * Send parse request.
	 *
	 * @param query
	 *            the query
	 * @return the response
	 */
	public static IntentResponse sendParseRequest(DataQuery query) {
		DataQuery q = new DataQuery();
		q.setQuery(query.getQuery());
		q.setProject(query.getProject());
		String response;
		try {
			response = NetworkUtils.postParse(q);

			IntentResponse resp = JsonUtils.fromJson(response, IntentResponse.class);
			return resp;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 

	}

	/**
	 * Send train request.
	 *
	 * @param jsonData
	 *            the json data
	 * @return the response
	 */
	public static TrainingResponse sendTrainRequest(TrainingResponse trainingData) {
		String response = NetworkUtils.postTrainingString(trainingData);
		TrainingResponse resp = JsonUtils.fromJson(response, TrainingResponse.class);
		return resp;
	}

	/**
	 * Send train file request.
	 *
	 * @param jsonFile
	 *            the json file
	 * @return the training response
	 */
	public static TrainingResponse sendTrainFileRequest(File jsonFile) {

		JsonParser parser = new JsonParser();
		Object obj;
		try {
			obj = parser.parse(new FileReader(jsonFile));
			JsonObject jsonObject = (JsonObject) obj;
			TrainingResponse resp = new TrainingResponse();//RasaService.sendTrainRequest(jsonObject.toString());
			return resp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public static IntentResponse getStatus() {
		String response = NetworkUtils.getStatus();
		IntentResponse resp = JsonUtils.fromJson(response, IntentResponse.class);
		return resp;

	}
}
