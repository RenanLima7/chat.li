package com.ufc.web.chatly.model;

import javax.persistence.Embeddable;

/*
@Data
@AllArgsConstructor
@NoArgsConstructor*/
@Embeddable
public class Contact{	
	private String name;
	
	private String email;
	
	private String genre;
	
	private byte[] avatar;

	public Contact() {
	}

	public Contact(String name, String email, String genre, byte[] avatar) {
		super();
		this.name = name;
		this.email = email;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}	
}