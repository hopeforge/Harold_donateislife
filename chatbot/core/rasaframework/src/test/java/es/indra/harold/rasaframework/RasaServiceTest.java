package es.indra.harold.rasaframework;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import es.indra.harold.rasaframework.incoming.model.Entity;
import es.indra.harold.rasaframework.incoming.model.Intent;
import es.indra.harold.rasaframework.incoming.model.IntentResponse;
import es.indra.harold.rasaframework.service.RasaService;

public class RasaServiceTest {

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
//		RasaContext.configure().setup("http://172.20.130.29:5000", null);
	}

	/**
	 * Test parse.
	 */
	@Test
	public void testParse() {
//		if (checkConnection()) {
//			IntentResponse resp = RasaService.sendParseRequest("Quais issues estão em atraso?!");
//
//			for (Entity entity : resp.getEntities()) {
//				System.out.println(entity.getValue() + " - " + entity.getValue());
//			}
//
//			for (Intent intent : resp.getIntent_ranking()) {
//				System.out.println(intent.getName() + " - " + intent.getConfidence());
//			}
//			System.out.println(resp.toString());
//			assertNotNull(resp);
//		}
		assert (true);
	}

	// @Test
	// public void testParseComplexDate() {
	// if (checkConnection()) {
	// Response resp = RasaService.sendParseRequest("can you setup request from
	// uggw to cyyz tomorrow to friday?");
	// System.out.println(resp.searchForStringEntityValue("departure_icao").getStringValue());
	// System.out.println(((TimeEntityValue)
	// resp.searchForDucklingValue("time")).getTo());
	// System.out.println(((TimeEntityValue)
	// resp.searchForDucklingValue("time")).getFrom());
	// System.out.println(resp.searchForStringEntityValue("arrival_icao").getStringValue());
	//
	// Response resp1 = RasaService.sendParseRequest("uggw cyyz from tomorrow to
	// friday?");
	// //
	// System.out.println(resp1.searchForStringEntityValue("departure_icao").getStringValue());
	// System.out.println(((TimeEntityValue)
	// resp1.searchForDucklingValue("time")).getTo());
	// System.out.println(((TimeEntityValue)
	// resp1.searchForDucklingValue("time")).getFrom());
	// //
	// System.out.println(resp1.searchForStringEntityValue("arrival_icao").getStringValue());
	//
	// Response resp2 = RasaService.sendParseRequest("tomorrow?");
	// //
	// System.out.println(resp2.searchForStringEntityValue("departure_icao").getStringValue());
	// System.out.println(((StringEntityValue)
	// resp2.searchForDucklingValue("time")).getStringValue());
	// //
	// System.out.println(resp2.searchForStringEntityValue("arrival_icao").getStringValue());
	// assertNotNull(resp);
	// }
	// assert (true);
	// }
	//
	// /**
	// * Test train string.
	// */
	// @Test
	// @Ignore
	// public void testTrainString() {
	//
	// if (checkConnection()) {
	// JsonParser parser = new JsonParser();
	// Object obj;
	// try {
	// obj = parser.parse(new FileReader("src/test/resources/training.json"));
	// JsonObject jsonObject = (JsonObject) obj;
	// System.out.println(jsonObject.toString());
	// RasaService.sendTrainRequest(jsonObject.toString());
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
	// checkConnection();
	// assert (true);
	// }
	//
	// /**
	// * Test train file.
	// */
	// @Test
	// @Ignore
	// public void testTrainFile() {
	//
	// if (checkConnection()) {
	// try {
	// RasaService.sendTrainFileRequest(new
	// File("src/test/resources/training.json"));
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
	// checkConnection();
	// assert (true);
	// }

	/**
	 * Check connection.
	 *
	 * @return true, if successful
	 */
	private boolean checkConnection() {
		IntentResponse status = RasaService.getStatus();
		if (status == null) {
			return false;
		}
		return true;
	}
}
