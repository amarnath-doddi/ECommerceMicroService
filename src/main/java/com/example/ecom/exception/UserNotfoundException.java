package com.example.ecom.exception;

public class UserNotfoundException extends RuntimeException {
	   private static final long serialVersionUID = 1L;
	   public UserNotfoundException(String message) {
			super(message);
	   }
	   
}