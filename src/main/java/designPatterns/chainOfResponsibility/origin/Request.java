package designPatterns.chainOfResponsibility.origin;

public class Request {

	String requestStr;
	
	public Request(String requestStr) {
		super();
		this.requestStr = requestStr;
	}

	public String getRequestStr() {
		return requestStr;
	}

	public void setRequestStr(String requestStr) {
		this.requestStr = requestStr;
	}
}
