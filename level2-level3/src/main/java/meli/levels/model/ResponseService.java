package meli.levels.model;

public class ResponseService {

	private Positions position;
	private String message;

	public ResponseService(Positions position, String message) {
		super();
		this.setPosition(position);
		this.message = message;
	}

	public Positions getPosition() {
		return position;
	}

	public void setPosition(Positions position) {
		this.position = position;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
