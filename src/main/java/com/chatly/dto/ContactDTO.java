package com.chatly.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
	@NotNull(message = "The 'userId' is required")
	private Long userId;

	@NotNull(message = "The 'contactId' is required")
	private Long contactId;
}
