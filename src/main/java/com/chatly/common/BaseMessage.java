package com.chatly.common;

/*@Data
@AllArgsConstructor
@NoArgsConstructor*/
public class BaseMessage {
	
	private String message;
	
	public BaseMessage() {
	}

	public BaseMessage(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
