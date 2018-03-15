package model;

public class SendMailInfo {
	
	private String sendTo;
	
	private String sendCc;
	
	private String sendSubject;
	
	private String sendContext;

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String getSendCc() {
		return sendCc;
	}

	public void setSendCc(String sendCc) {
		this.sendCc = sendCc;
	}

	public String getSendContext() {
		return sendContext;
	}

	public void setSendContext(String sendContext) {
		this.sendContext = sendContext;
	}

	public String getSendSubject() {
		return sendSubject;
	}

	public void setSendSubject(String sendSubject) {
		this.sendSubject = sendSubject;
	}

}
