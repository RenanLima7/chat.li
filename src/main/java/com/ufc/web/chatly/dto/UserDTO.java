package com.ufc.web.chatly.dto;

import javax.validation.constraints.*;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO{
	@NotBlank(message = "The 'name' is required")
	@NotNull(message = "The 'name' is required")
	private String name;
	
	@NotBlank(message = "The 'email' is required")
	@NotNull(message = "The 'email' is required")
	@Email(message = "The 'email' is invalided")
	private String email;
	
	@NotBlank(message = "The 'password' is required")
	@NotNull(message = "The 'password' is required")
	@Size(message = "The 'password' must be at least 8 characters long", min = 8) 
	private String password;
	
	@NotBlank(message = "The 'genre' is required")
	@NotNull(message = "The 'genre' is required")
	private String genre;
	
	private String avatar; 
}
