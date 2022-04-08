package com.maplr.testhockeygame.exception;

import java.util.function.Supplier;

public class TeamNotFoundException extends ResourceNotFoundException {

	public TeamNotFoundException(String message) {
		super(message);
	}

	public static Supplier<TeamNotFoundException> forYear(long year){
		return () -> new TeamNotFoundException(String.format("Team not found for year: %s", year));
	}
}
