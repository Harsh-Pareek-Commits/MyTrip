package com.g5.tms.security;

public class JwtResponse {
String token;
int id;


public JwtResponse() {
	super();
	
}


public JwtResponse(String token, int id) {
	super();
	this.token = token;
	this.id = id;
}


public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


}
