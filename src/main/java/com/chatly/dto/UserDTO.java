package com.chatly.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/*
@Data
@AllArgsConstructor
@NoArgsConstructor*/
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

	
	
	public UserDTO() {
	}

	public UserDTO(
			@NotBlank(message = "The 'name' is required") @NotNull(message = "The 'name' is required") String name,
			@NotBlank(message = "The 'email' is required") @NotNull(message = "The 'email' is required") @Email(message = "The 'email' is invalided") String email,
			@NotBlank(message = "The 'password' is required") @NotNull(message = "The 'password' is required") @Size(message = "The 'password' must be at least 8 characters long", min = 8) String password,
			@NotBlank(message = "The 'genre' is required") @NotNull(message = "The 'genre' is required") String genre,
			String avatar) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.genre = genre;
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	} 
}
