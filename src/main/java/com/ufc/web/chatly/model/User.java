package com.ufc.web.chatly.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "user_id")
	private Long id;
	
	@Column(nullable = false, length = 150)
	private String name;
	
	@Column(unique = true, nullable = false, length = 150)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String genre;
	
	@Lob
	@Column(nullable = true)
	private byte[] avatar;
	
	@ElementCollection
	@CollectionTable(name = "user_contacts",
			joinColumns = @JoinColumn(name = "user_id"))	
	private List<Contact> contacts;
}