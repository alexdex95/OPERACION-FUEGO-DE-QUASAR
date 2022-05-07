package meli.levels.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import meli.levels.exceptions.MessageException;
import meli.levels.model.Positions;
import meli.levels.model.RequestServiceLevelThree;
import meli.levels.model.ResponseService;
import meli.levels.utils.SessionUtil;
import meli.levels.utils.Utils;

@Service
public class ILevelThreeImplement implements ILevelThree {

	protected final String[] SATELITE = { "sat1", "sat2", "sat3" };
	protected final String[] LOCATION = { "Location_sat1", "Location_sat2", "Location_sat3", };

	protected HttpServletRequest session;

	public HttpServletRequest getSession() {
		return session;
	}

	public void setSession(HttpServletRequest session) {
		this.session = session;
	}

	@Autowired(required = true)
	private Utils utils;

	@Autowired
	SessionUtil sessionUtil;

	@Override
	public void topsecretSplit(RequestServiceLevelThree satelliteName, String nameSatellite,
			HttpServletRequest request) {
		setSession(request);
		if (nameSatellite.equals("kenobi")) {
			session.getSession().setAttribute("sat1", nameSatellite);
			session.getSession().setAttribute("Location_sat1", satelliteName);
		} else if (nameSatellite.equals("skywalker")) {
			session.getSession().setAttribute("sat2", nameSatellite);
			session.getSession().setAttribute("Location_sat2", satelliteName);
		} else if (nameSatellite.equals("sato")) {
			session.getSession().setAttribute("sat3", nameSatellite);
			session.getSession().setAttribute("Location_sat3", satelliteName);
		}
	}

	@Override
	public ResponseService topsecretSplit() throws MessageException {
		List<RequestServiceLevelThree> satellites = new ArrayList<>();
		double[] puntos = new double[3];
		List<String[]> mensajes = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (session.getSession().getAttribute(SATELITE[i]) != null) {
				RequestServiceLevelThree datos = (RequestServiceLevelThree) session.getSession()
						.getAttribute(LOCATION[i]);

				satellites.add(datos);
			}
		}

		for (int i = 0; i < satellites.size(); i++) {
			puntos[i] = satellites.get(i).getDistance();
			mensajes.add(satellites.get(i).getMessage());
		}

		if (satellites.size() == 3) {
			sessionUtil.destroySession(getSession());
			return new ResponseService(new Positions(utils.getlocation(puntos)),
					utils.getmessage(utils.getmessage(satellites)));
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Numero de satelites menor a 3");
		}
	}

}
