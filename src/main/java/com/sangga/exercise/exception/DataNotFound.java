package com.sangga.exercise.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DataNotFound extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataNotFound() {
        super("Data not Found!");
    }
	
	public DataNotFound(final String message) {
        super(message);
    }
}
