package meli.levels.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import meli.levels.exceptions.MessageException;

public class SatelliteMapping {

	@JsonProperty("satellites")
	private List<Satellite> satellites;

	public List<Satellite> getSatellites() {
		return satellites;
	}

	public void setSatellites(List<Satellite> satellites) {
		this.satellites = satellites;
	}

	public double[] getDistances() throws MessageException {
		double[] distances = new double[satellites.size()];
		for (int i = 0; i < distances.length; i++) {
			if (satellites.get(i).getDistance() == 0)
				throw new MessageException("valores de distancia incompletos");
			distances[i] = satellites.get(i).getDistance();
		}
		return distances;

	}

	public String[] getmessage() throws MessageException {
		String[] messages = new String[5];
		for (int i = 0; i < satellites.size(); i++) {
			if (satellites.get(i).getMessage() == null || satellites.get(i).getMessage().length == 0)
				throw new MessageException("mensajes incompletos");
			if (i == 0) {
				messages[0] = satellites.get(i).getMessage()[0];
				messages[3] = satellites.get(i).getMessage()[3];
			} else if (i == 1) {
				messages[1] = satellites.get(i).getMessage()[1];
				messages[4] = satellites.get(i).getMessage()[4];
			} else if (i == 2) {
				messages[2] = satellites.get(i).getMessage()[2];
			}
		}
		return messages;
	}

}
