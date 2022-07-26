package com.chatly.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/*
@Data
@AllArgsConstructor
@NoArgsConstructor*/
@Entity(name = "message")
public class Message{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "message_d")
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

	public Message() {
	}

	public Message(Long id, Long senderId, Long addresseeId, String content, Date createdDate) {
		super();
		this.senderId = senderId;
		this.addresseeId = addresseeId;
		this.content = content;
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getAddresseeId() {
		return addresseeId;
	}

	public void setAddresseeId(Long addresseeId) {
		this.addresseeId = addresseeId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
