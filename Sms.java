package com.example.parser;

public class Sms {
	
	private String adress;
	private String body;
	private String date;
	private String id;
	
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	

	
	public String toString() {
		return "Sms [adress=" + adress + ", body=" + body + ", date=" + date + ", id=" + id + "]";
	}

}
