package com.ufc.web.chatly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatLyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatLyApplication.class, args);
		System.out.println("======================="
				+ "Server ON"
				+ "\"=======================\"");
	}
}
