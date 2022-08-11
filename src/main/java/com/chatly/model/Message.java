package com.chatly.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "message")
@Table(name = "tb_message")
public class Message{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "message_id")
	private Long id;
	
	@Column(nullable = false)
	private Long senderId; 
	
	@Column(nullable = false)
	private Long addresseeId; 
	
	@Column(nullable = false)
	private String content; 
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
}
