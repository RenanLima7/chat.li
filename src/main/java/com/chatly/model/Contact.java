package com.chatly.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Contact{	
	private String name;
	
	private String email;
	
	private String occupation;
	
	private String avatar;
}