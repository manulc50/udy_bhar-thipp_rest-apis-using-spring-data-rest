package com.mlorenzo.eventmanagementapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NotCheckInException extends RuntimeException {
	
	private static final long serialVersionUID = -6107357224463432713L;

	public NotCheckInException(String message) {
		super(message);
	}

}
