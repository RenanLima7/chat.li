package com.chatly.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
	@NotNull(message = "The 'senderId' is required")
	private Long senderId;

	@NotNull(message = "The 'addresseeId' is required")
	private Long addresseeId;

	@NotBlank(message = "The 'content' is required")
	@NotNull(message = "The 'content' is required")
	private String content;
}
