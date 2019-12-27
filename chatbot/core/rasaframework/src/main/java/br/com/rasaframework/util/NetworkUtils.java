package br.com.rasaframework.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import br.com.rasaframework.RasaContext;
import br.com.rasaframework.exception.RasaPluginError;
import br.com.rasaframework.exception.RasaPluginErrorMessage;
import br.com.rasaframework.incoming.model.TrainingResponse;
import br.com.rasaframework.outgoing.model.DataQuery;

/**
 * The Class NetworkUtils.
 */
public class NetworkUtils {

	private static final String APPLICATION_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";
	private static final String CONTENT_TYPE = "Content-Type";
	private static final String APPLICATION_JSON = "application/json";
	/**
	 * The logger.
	 */
	private static final Logger logger = Logger.getGlobal();

	/**
	 * Post json config.
	 *
	 * @param input
	 *            the input
	 * @return the string
	 * @throws URISyntaxException
	 */
	public static String postParse(DataQuery input) throws URISyntaxException {
		// StringEntity stringEntity = toStringEntity(input);

		List<NameValuePair> params = new LinkedList<NameValuePair>();
		params.add(new BasicNameValuePair("q", input.getQuery()));
		params.add(new BasicNameValuePair("project", input.getProject()));

		URI uri = new URIBuilder().setScheme(RasaContext.getRasaConfig().getProtocol())
				.setHost(RasaContext.getRasaConfig().getHost()).setPort(RasaContext.getRasaConfig().getPort())
				.setPath(NetworkConstants.PRASE_EP).addParameter("q", input.getQuery())
				.addParameter("project", input.getProject()).build();

		HttpGet get = new HttpGet(uri);

		return send(get);
	}

	/**
	 * Post json message.
	 *
	 * @param jsonData
	 *            the json data
	 * @return the string
	 */
	public static String postTrainingString(TrainingResponse jsonData) {
		StringEntity stringEntity;
		try {
			HttpPost post = new HttpPost(
					RasaContext.getRasaConfig().toString() + NetworkConstants.TRAIN_EP + concatProject(jsonData));
			if(jsonData.getDataJson() != null) {
				stringEntity = new StringEntity(jsonData.getDataJson(), "UTF-8");
				stringEntity.setContentType(APPLICATION_JSON);
				post.setEntity(stringEntity);				
			}
			return send(post);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static String concatProject(TrainingResponse jsonData) {
		if (jsonData.getProject() != null) {
			return "?project=" + jsonData.getProject();
		} else {
			return "";
		}
	}

	/**
	 * Post json message broadcast.
	 *
	 * @return the string
	 */
	public static String getStatus() {
		HttpGet get = new HttpGet(RasaContext.getRasaConfig().toString() + NetworkConstants.STATUS_EP + concatToken());
		get.setHeader(CONTENT_TYPE, APPLICATION_JSON);
		return send(get);
	}

	/**
	 * Send.
	 *
	 * @param request
	 *            the request
	 * @return the string
	 */
	private static String send(HttpRequestBase request) {

		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		logger.log(Level.SEVERE, request.getRequestLine().toString());
		HttpResponse httpResponse = null;
		String response = null;
		try {
			httpResponse = httpClient.execute(request);
			response = logResponse(httpResponse);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error during HTTP connection to RASA: ", e);
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				logger.log(Level.SEVERE, "Error while closing HTTP connection: ", e);
			}
		}
		return response;
	}

	/**
	 * DELETEs a JSON string to Facebook.
	 * 
	 * @param input
	 *            the JSON data to send.
	 */
	public static void delete(Object input) {
		StringEntity stringEntity = toStringEntity(input);
		delete(stringEntity);
	}

	/**
	 * Post.
	 *
	 * @param url
	 *            the url
	 * @param entity
	 *            the entity
	 * @return the string
	 */
	public static String post(String url, StringEntity entity) {
		HttpPost post = new HttpPost(url);
		post.setHeader(CONTENT_TYPE, APPLICATION_X_WWW_FORM_URLENCODED);
		post.setEntity(entity);
		return send(post);
	}

	/**
	 * Utility to send a GET request.
	 * 
	 * @param url
	 *            the url we need to send the get request to.
	 * @return {@link String}
	 */
	public static String get(String url) {
		HttpGet get = new HttpGet(url);
		return send(get);
	}

	/**
	 * To string entity.
	 *
	 * @param object
	 *            the object
	 * @return the string entity
	 */
	private static StringEntity toStringEntity(Object object) {
		StringEntity input = null;
		try {
			String json = JsonUtils.toJson(object);
			input = new StringEntity(json);
			input.setContentType(APPLICATION_JSON);
			logger.log(Level.SEVERE, "Request: {}", inputStreamToString(input.getContent()));
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error during JSON message creation: ", e);
		}
		return input;
	}

	/**
	 * Utility method which converts an InputStream to a String.
	 *
	 * @param stream
	 *            the InputStream to convert.
	 * @return a String with the InputStream content.
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static String inputStreamToString(InputStream stream) throws IOException {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length;
		String resultString = null;
		while ((length = stream.read(buffer)) != -1) {
			result.write(buffer, 0, length);
		}
		resultString = result.toString("UTF-8");
		return resultString;
	}

	/**
	 * Logs the response before returning it.
	 *
	 * @param response
	 *            the response to log.
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static String logResponse(HttpResponse response) throws IOException {
		int statusCode = response.getStatusLine().getStatusCode();

		// Logs the raw JSON for debug purposes.
		String output = getResponseContent(response);
		logger.log(Level.SEVERE, "HTTP Status Code: {}", statusCode);
		logger.log(Level.SEVERE, "Response: {}", output);

		if (statusCode >= 400) {
			logger.log(Level.SEVERE, "HTTP connection failed with error code {}.", statusCode);

			// Parses the error message and logs it.
			RasaPluginErrorMessage errorMessage = JsonUtils.fromJson(output, RasaPluginErrorMessage.class);
			RasaPluginError error = errorMessage.getError();
			logger.log(Level.SEVERE, "Error message from Kik. Message: [{}], Code: [{}], Type: [{}], FbTraceID: [{}]."
					+ error.getMessage());
		}
		return output;
	}

	/**
	 * Utility method that converts an HttpResponse to a String.
	 *
	 * @param response
	 *            the response to convert.
	 * @return a String with the response content.
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static String getResponseContent(HttpResponse response) throws IOException {
		InputStream inputStream = response.getEntity().getContent();
		BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
		InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
		BufferedReader br = new BufferedReader(inputStreamReader);
		StringBuilder builder = new StringBuilder();
		String output = null;
		while ((output = br.readLine()) != null) {
			builder.append(output);
		}
		return builder.toString();
	}

	/**
	 * Concat token.
	 *
	 * @return the string
	 */
	private static String concatToken() {
		if (RasaContext.getRasaConfig().getToken() != null) {
			return "?token=" + RasaContext.getRasaConfig().getToken();
		} else {
			return "";
		}
	}

}
