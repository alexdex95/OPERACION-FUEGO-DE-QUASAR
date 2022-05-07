package meli.levels.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestServiceLevelThree {

	@JsonProperty("distance")
	private double distance;

	@JsonProperty("message")
	private String[] message;

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String[] getMessage() {
		return message;
	}

	public void setMessage(String[] message) {
		this.message = message;
	}
}
