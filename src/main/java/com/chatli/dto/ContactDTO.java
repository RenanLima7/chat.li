package com.ufc.web.chatly.dto;

import javax.validation.constraints.NotNull;

/*
@Data
@AllArgsConstructor
@NoArgsConstructor*/
public class ContactDTO {
	@NotNull(message = "The 'userId' is required")
	private Long userId;

	@NotNull(message = "The 'contactId' is required")
	private Long contactId;

	public ContactDTO() {
	}
	
	public ContactDTO(@NotNull(message = "The 'userId' is required") Long userId,
			@NotNull(message = "The 'contactId' is required") Long contactId) {
		super();
		this.userId = userId;
		this.contactId = contactId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}
}
