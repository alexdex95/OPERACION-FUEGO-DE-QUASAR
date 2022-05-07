package meli.levels.service;

import meli.levels.exceptions.MessageException;
import meli.levels.model.ResponseService;
import meli.levels.model.SatelliteMapping;

public interface ILevelTwo {

	public ResponseService topSecret(SatelliteMapping numero) throws MessageException;

}