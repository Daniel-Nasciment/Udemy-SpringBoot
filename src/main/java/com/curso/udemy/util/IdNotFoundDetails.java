package com.curso.udemy.util;

import java.time.LocalDateTime;

public class IdNotFoundDetails {

	private String message;

	private Integer status;

	private String detalis;

	private LocalDateTime timeStamp;

	@Deprecated
	public IdNotFoundDetails() {

	}

	public IdNotFoundDetails(String message, Integer status, String detalis, LocalDateTime timeStamp) {
		this.message = message;
		this.status = status;
		this.detalis = detalis;
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public Integer getStatus() {
		return status;
	}

	public String getDetalis() {
		return detalis;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

}
