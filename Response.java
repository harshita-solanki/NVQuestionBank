package com.nv.questionbank.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Response {
private String responseStatus;
private int responseCode;
private ResponseData data;
private String message;
public String getResponseStatus() {
	return responseStatus;
}
public void setResponseStatus(String responseStatus) {
	this.responseStatus = responseStatus;
}
public int getResponseCode() {
	return responseCode;
}
public void setResponseCode(int responseCode) {
	this.responseCode = responseCode;
}
public ResponseData getData() {
	return data;
}
public void setData(ResponseData data) {
	this.data = data;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

}
