package com.mlorenzo.eventmanagementapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyCheckedInException extends RuntimeException {
	
	private static final long serialVersionUID = 5054011015405671145L;

	public AlreadyCheckedInException(String message) {
		super(message);
	}

}
