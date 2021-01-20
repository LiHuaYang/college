package com.Tool;

public class MyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String errorMessage;
	
	public MyException(String errMessage){
		this.errorMessage = errMessage;
	}
	
	public String getMessage(){
		return errorMessage;
	}
	
	public String toString(){
		return errorMessage;
	}
	
}
