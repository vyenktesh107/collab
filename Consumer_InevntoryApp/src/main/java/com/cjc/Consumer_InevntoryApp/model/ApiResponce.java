package com.cjc.Consumer_InevntoryApp.model;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponce {

	private int statuscode;
	private String message;
	private HttpStatus statusMessage;
	private String urlPath;
	private Date date;
}
