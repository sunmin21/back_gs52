package com.gs52.jwt.payload.response;

public class MessageResponse {  // Request에 대한 Response를 Message 형태로 나타낸 것임
	private String message;

	public MessageResponse(String message) {
	    this.message = message;
	  }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
