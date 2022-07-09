package com.ufc.web.chatly.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import lombok.*;

@Entity
@Data
@Getter
@Setter
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
	private String occupation;
	
	@Lob
	@Column(nullable = true)
	private byte[] avatar;
}