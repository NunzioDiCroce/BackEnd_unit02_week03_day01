package com.example.Unit02Week03Day01.exceptions;

public class ItemNotFoundException extends RuntimeException {

	public ItemNotFoundException(long _id) {
		super("Item with id " + _id + " not found!");
	}

}
