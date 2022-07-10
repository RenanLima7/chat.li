package com.ufc.web.chatly.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Contact{
	@Column(name = "contact_id")
	private Long id;
	
	private String name;
	
	private String email;
	
	private String genre;
	
	private byte[] avatar;
}