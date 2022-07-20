package com.ufc.web.chatly.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/*
@Data
@AllArgsConstructor
@NoArgsConstructor*/
public class MessageDTO {
	@NotNull(message = "The 'senderId' is required")
	private Long senderId;

	@NotNull(message = "The 'addresseeId' is required")
	private Long addresseeId;

	@NotBlank(message = "The 'content' is required")
	@NotNull(message = "The 'content' is required")
	private String content;

	public MessageDTO() {
	}

	public MessageDTO(@NotNull(message = "The 'senderId' is required") Long senderId,
			@NotNull(message = "The 'addresseeId' is required") Long addresseeId,
			@NotBlank(message = "The 'content' is required") @NotNull(message = "The 'content' is required") String content) {
		super();
		this.senderId = senderId;
		this.addresseeId = addresseeId;
		this.content = content;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getAddresseeId() {
		return addresseeId;
	}

	public void setAddresseeId(Long addresseeId) {
		this.addresseeId = addresseeId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
