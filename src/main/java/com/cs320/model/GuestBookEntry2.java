package com.cs320.model;

import java.util.Date;

public class GuestBookEntry2 {

	String name;

	String message;

	Date date;

	public GuestBookEntry2() {
		date = new Date();
	}

	public GuestBookEntry2(String name, String message) {
		this.name = name;
		this.message = message;
		this.date = new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}