package com.springboot.swagger.example.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyResponse {

	@JsonProperty(value="error_code")
	private Integer errorcode;
	
	@JsonProperty(value="error_message")
	private String errormessage;
	
	@JsonProperty(value="success_code")
	private Integer successcode;
	
	@JsonProperty(value="success_message")
	private String successmessage;
	
	public Integer getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(Integer errorcode) {
		this.errorcode = errorcode;
	}
	public String getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	public Integer getSuccesscode() {
		return successcode;
	}
	public void setSuccesscode(Integer successcode) {
		this.successcode = successcode;
	}
	public String getSuccessmessage() {
		return successmessage;
	}
	public void setSuccessmessage(String successmessage) {
		this.successmessage = successmessage;
	}
}
