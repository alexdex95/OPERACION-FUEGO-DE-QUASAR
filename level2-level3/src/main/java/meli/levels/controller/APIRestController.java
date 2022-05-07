package meli.levels.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import meli.levels.exceptions.MessageException;
import meli.levels.model.RequestServiceLevelThree;
import meli.levels.model.ResponseService;
import meli.levels.model.SatelliteMapping;
import meli.levels.service.ILevelThree;
import meli.levels.service.ILevelTwo;

@RestController
@RequestMapping(path = "${communication.context.path}")
public class APIRestController {

	@Autowired(required = true)
	private ILevelTwo levelTwo;

	@Autowired(required = true)
	private ILevelThree levelThree;

	@PostMapping(path = "${service.level.two}")
	public ResponseEntity<ResponseService> topSecret(@RequestBody SatelliteMapping satellites) {
		try {
			if (satellites.getSatellites() == null || satellites.getSatellites().isEmpty()) {
				throw new MessageException("JSON Incompleto");
			}
			return ResponseEntity.status(HttpStatus.OK).body(levelTwo.topSecret(satellites));
		} catch (MessageException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	@PostMapping(path = "${service.level.three}/{satelliteName}")
	public ResponseEntity<String> topsecretSplit(@PathVariable("satelliteName") String nameSatelite,
			@RequestBody RequestServiceLevelThree body, HttpServletRequest request) {
		try {
			if (!nameSatelite.equals("kenobi") && !nameSatelite.equals("skywalker") && !nameSatelite.equals("sato"))
				throw new MessageException("Satelite no encontrado");
			if (body.getDistance() == 0 || body.getMessage() == null || body.getMessage().length == 0) {
				throw new MessageException("valores de distancia incompletos o mensajes incompletos");
			}
			levelThree.topsecretSplit(body, nameSatelite, request);
			return ResponseEntity.status(HttpStatus.OK).body("OK");
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}

	@GetMapping("${service.level.three}")
	public ResponseEntity<ResponseService> topsecretSplit() {
		try {
			return new ResponseEntity<>(levelThree.topsecretSplit(), HttpStatus.OK);
		} catch (MessageException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
		}
	}
}