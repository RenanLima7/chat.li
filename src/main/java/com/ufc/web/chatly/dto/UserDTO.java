package com.ufc.web.chatly.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO{
	@NotEmpty
	@NotBlank
	@NotNull
	private String name;
	
	@NotEmpty
	@NotBlank
	@NotNull
	private String email;
	
	@NotEmpty
	@NotBlank
	@NotNull
	private String password;
	
	private byte[] avatar; 
}
