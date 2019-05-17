package com.sony.ifbatch.common.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.MessageSourceResolvable;
import org.springframework.validation.Errors;

public class BusinessException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7462614071475030654L;
	private final transient Errors errors;
	private final transient List<MessageSourceResolvable> resolvableList;

	public BusinessException() {
		this.errors = null;
		this.resolvableList = null;
	}

	public BusinessException(String message) {
		super(message);
		this.errors = null;
		this.resolvableList = null;
	}

	public BusinessException(Throwable cause) {
		super(cause);
		this.errors = null;
		this.resolvableList = null;
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
		this.errors = null;
		this.resolvableList = null;
	}

	public BusinessException(Errors errors) {
		this.errors = errors;
		this.resolvableList = null;
	}

	public BusinessException(MessageSourceResolvable resolvable) {
		ArrayList<MessageSourceResolvable> list = new ArrayList<MessageSourceResolvable>();
		list.add(resolvable);
		this.resolvableList = list;
		this.errors = null;
	}

	public BusinessException(List<MessageSourceResolvable> resolvableList) {
		this.resolvableList = resolvableList;
		this.errors = null;
	}

	public Errors getErrors() {
		return this.errors;
	}

	public List<MessageSourceResolvable> getResolvableList() {
		return this.resolvableList;
	}
}