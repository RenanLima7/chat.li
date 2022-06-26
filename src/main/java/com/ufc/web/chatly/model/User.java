package com.ufc.web.chatly.model;

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
	private Long id;
	
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