package com.example.Unit02Week03Day01.exceptions;

import java.util.UUID;

public class ItemNotFoundException extends RuntimeException {

	public ItemNotFoundException(UUID _id) {
		super("Item with id " + _id + " not found!");
	}

}
