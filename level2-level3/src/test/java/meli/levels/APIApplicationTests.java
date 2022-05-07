package meli.levels;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import meli.levels.controller.APIRestController;
import meli.levels.exceptions.MessageException;
import meli.levels.model.RequestServiceLevelThree;
import meli.levels.model.ResponseService;
import meli.levels.model.Satellite;
import meli.levels.model.SatelliteMapping;

@SpringBootTest
class APIApplicationTests {

	@Autowired(required = true)
	private MockHttpServletRequest request;

	@Autowired(required = true)
	private APIRestController apiRestController;

	@Test
	void topSecret() throws MessageException {

		SatelliteMapping satelites = new SatelliteMapping();
		List<Satellite> arrySatelites = new ArrayList<Satellite>();

		Satellite satelite1 = new Satellite();
		satelite1.setName("kenobi");
		satelite1.setDistance(100.0);
		satelite1.setMessage(new String[] { "este", "", "", "mensaje", "" });
		arrySatelites.add(satelite1);

		Satellite satelite2 = new Satellite();
		satelite2.setName("skywalker");
		satelite2.setDistance(115.5);
		satelite2.setMessage(new String[] { "", "es", "", "", "secreto" });
		arrySatelites.add(satelite2);

		Satellite satelite3 = new Satellite();
		satelite3.setName("sato");
		satelite3.setDistance(142.7);
		satelite3.setMessage(new String[] { "este", "", "un", "", "" });
		arrySatelites.add(satelite3);

		satelites.setSatellites(arrySatelites);

		ResponseEntity<ResponseService> ResponseService = apiRestController.topSecret(satelites);
		assertEquals(HttpStatus.OK, ResponseService.getStatusCode());

	}

	@Test
	void topsecretSplitKenobi() throws MessageException {

		RequestServiceLevelThree satelite1 = new RequestServiceLevelThree();
		satelite1.setDistance(100.0);
		satelite1.setMessage(new String[] { "este", "", "", "mensaje", "" });

		ResponseEntity<String> ResponseService = apiRestController.topsecretSplit("kenobi", satelite1, request);
		assertEquals(HttpStatus.OK, ResponseService.getStatusCode());
	}

	@Test
	void topsecretSplitSkywalker() throws MessageException {

		RequestServiceLevelThree satelite1 = new RequestServiceLevelThree();
		satelite1.setDistance(115.5);
		satelite1.setMessage(new String[] { "", "es", "", "", "secreto" });

		ResponseEntity<String> ResponseService = apiRestController.topsecretSplit("skywalker", satelite1, request);
		assertEquals(HttpStatus.OK, ResponseService.getStatusCode());
	}

	@Test
	void topsecretSplitSato() throws MessageException {

		RequestServiceLevelThree satelite1 = new RequestServiceLevelThree();
		satelite1.setDistance(142.7);
		satelite1.setMessage(new String[] { "este", "", "un", "", "" });

		ResponseEntity<String> ResponseService = apiRestController.topsecretSplit("sato", satelite1, request);
		assertEquals(HttpStatus.OK, ResponseService.getStatusCode());
	}

	@Test
	void topsecretSplit() throws MessageException {

		RequestServiceLevelThree satelite1 = new RequestServiceLevelThree();
		satelite1.setDistance(100.0);
		satelite1.setMessage(new String[] { "este", "", "", "mensaje", "" });

		apiRestController.topsecretSplit("kenobi", satelite1, request);

		RequestServiceLevelThree satelite2 = new RequestServiceLevelThree();
		satelite2.setDistance(115.5);
		satelite2.setMessage(new String[] { "", "es", "", "", "secreto" });

		apiRestController.topsecretSplit("skywalker", satelite2, request);

		RequestServiceLevelThree satelite3 = new RequestServiceLevelThree();
		satelite3.setDistance(142.7);
		satelite3.setMessage(new String[] { "este", "", "un", "", "" });

		apiRestController.topsecretSplit("sato", satelite3, request);

		ResponseEntity<ResponseService> ResponseService4 = apiRestController.topsecretSplit();
		assertEquals(HttpStatus.OK, ResponseService4.getStatusCode());
	}

}
