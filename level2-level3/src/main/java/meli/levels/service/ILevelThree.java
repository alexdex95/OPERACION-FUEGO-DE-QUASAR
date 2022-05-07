package meli.levels.service;

import javax.servlet.http.HttpServletRequest;

import meli.levels.exceptions.MessageException;
import meli.levels.model.RequestServiceLevelThree;
import meli.levels.model.ResponseService;

public interface ILevelThree {

	public void topsecretSplit(RequestServiceLevelThree satelliteName, String nameSatellite,
			HttpServletRequest request);

	public ResponseService topsecretSplit() throws MessageException;

}