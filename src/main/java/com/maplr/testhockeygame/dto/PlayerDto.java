package com.maplr.testhockeygame.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@JsonInclude(Include.NON_DEFAULT)
public class PlayerDto {

	@NonNull
	private Long  number;

	@NonNull
	private String name;

	@NonNull
	private String lastname;

	@NonNull
	private String position;

	@JsonProperty("isCaptain")
	private boolean isCaptain;
}
