package com.test.project.utils;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author usman
 *
 */
@XmlRootElement
public class ResponseClass implements Serializable{
	
	private String message;
	private Object data;
	private boolean success;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public static ResponseClass getResponse( String message, boolean success, Object data) {
		ResponseClass response = new ResponseClass();
		response.setData(data);
		response.setMessage(message);
		response.setSuccess(success);
		return response;
	}
	
	
}
