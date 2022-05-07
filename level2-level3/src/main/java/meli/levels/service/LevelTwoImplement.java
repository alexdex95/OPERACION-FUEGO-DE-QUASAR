package meli.levels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import meli.levels.exceptions.MessageException;
import meli.levels.model.Positions;
import meli.levels.model.ResponseService;
import meli.levels.model.SatelliteMapping;
import meli.levels.utils.Utils;

@Service
public class LevelTwoImplement implements ILevelTwo {

	@Autowired(required = true)
	private Utils utils;

	@Override
	public ResponseService topSecret(SatelliteMapping satellites) throws MessageException {
		double[] valueXY = utils.getlocation(satellites.getDistances());
		String[] messages = satellites.getmessage();
		return new ResponseService(new Positions(valueXY), utils.getmessage(messages));
	}

}
