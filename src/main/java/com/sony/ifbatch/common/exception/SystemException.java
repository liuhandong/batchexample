package com.sony.ifbatch.common.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSourceResolvable;
import org.springframework.validation.Errors;

public class SystemException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5607581370386820537L;
	private final transient Errors errors;
	private final transient List<MessageSourceResolvable> resolvableList;
	private final transient String exceptionMessage;


	public SystemException(String message, Throwable cause) {
		super(message, cause);
		this.errors = null;
		this.resolvableList = null;
		this.exceptionMessage = null;
	}

	public SystemException(String message) {
		super(message);
		this.errors = null;
		this.resolvableList = null;
		this.exceptionMessage = null;
	}

	public SystemException(Errors errors) {
		this.errors = errors;
		this.resolvableList = null;
		this.exceptionMessage = null;
	}

	public SystemException(MessageSourceResolvable resolvable) {
		ArrayList<MessageSourceResolvable> list = new ArrayList<MessageSourceResolvable>();
		list.add(resolvable);
		this.resolvableList = list;
		this.errors = null;
		this.exceptionMessage = null;
	}

	public SystemException(MessageSourceResolvable resolvable,Exception e) {
		ArrayList<MessageSourceResolvable> list = new ArrayList<MessageSourceResolvable>();
		list.add(resolvable);
		this.resolvableList = list;
		this.errors = null;
		this.exceptionMessage= e.getMessage();
	}


	public Errors getErrors() {
		return this.errors;
	}

	public List<MessageSourceResolvable> getResolvableList() {
		return this.resolvableList;
	}

	public String getExceptionMessage() {
		return this.exceptionMessage;
	}

}
