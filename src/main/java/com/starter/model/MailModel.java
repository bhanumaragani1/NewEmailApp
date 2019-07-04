package com.starter.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class MailModel {
	
	private String to;
	private String sub;
	private String[] cc;
	private String[] bcc;
	@NotEmpty(message = "Please provide a author")
	private String text;
	
}
