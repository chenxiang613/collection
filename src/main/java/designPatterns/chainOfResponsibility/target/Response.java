package designPatterns.chainOfResponsibility.target;

public class Response {
	String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Response(String response) {
		super();
		this.response = response;
	}
}
