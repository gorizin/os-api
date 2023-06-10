package com.igor.os.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;

	private List<FieldMessade> erros = new ArrayList<>();

	public ValidationError() {
		super();

	}

	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);

	}

	public List<FieldMessade> getErros() {
		return erros;
	}

	public void addErrors(String fieldName, String message) {
		this.erros.add(new FieldMessade(fieldName.concat(message), message));
	}

}
