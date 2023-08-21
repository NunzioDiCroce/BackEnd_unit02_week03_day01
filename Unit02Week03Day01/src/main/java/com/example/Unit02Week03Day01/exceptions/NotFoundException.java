package com.example.Unit02Week03Day01.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {

	public NotFoundException(String message) {
		super(message);
	}

	public NotFoundException(UUID id) {
		super(id + " non trovato!");
	}

}
