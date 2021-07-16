package com.g5.tms.security;

public class JwtResponse {
String token;
int id;
String userType;

public JwtResponse() {
	super();
	
}


public JwtResponse(String token, int id, String userType) {
	super();
	this.token = token;
	this.id = id;
	this.userType = userType;
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


public String getUserType() {
	return userType;
}


public void setUserType(String userType) {
	this.userType = userType;
}


@Override
public String toString() {
	return "JwtResponse [token=" + token + ", id=" + id + ", userType=" + userType + "]";
}


}
