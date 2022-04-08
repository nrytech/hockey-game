package com.maplr.testhockeygame.dto;

import java.util.List;

import lombok.Data;
import lombok.NonNull;

@Data
public class TeamDto {
	@NonNull
	private Long id;

	@NonNull
	private Long year;

	@NonNull
	private String coach;

	@NonNull
	private List<PlayerDto> players;
}
