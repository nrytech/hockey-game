package com.maplr.testhockeygame.exception;

import java.util.function.Supplier;

public class PlayerNotFoundException extends ResourceNotFoundException {

	public PlayerNotFoundException(String message) {
		super(message);
	}

	public static Supplier<PlayerNotFoundException> withId(long id){
		return () -> new PlayerNotFoundException(String.format("Player not found with id: %s", id));
	}
}
