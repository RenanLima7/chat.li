package com.ufc.web.chatly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ChatLyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatLyApplication.class, args);
		System.out.println("=======================");
		System.out.println("\tServer ON");
		System.out.println("=======================");
	}
}
