package com.ufc.web.chatly.model;

import java.util.UUID;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private UUID id;
	
	@Column(nullable = false, length = 150)
	private String name;
	
	@Column(unique = true, nullable = false, length = 150)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Lob
	@Column(nullable = true)
	private byte[] avatar;
}