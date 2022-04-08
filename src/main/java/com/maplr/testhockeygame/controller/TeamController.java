package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.entity.PlayerEntity;
import com.maplr.testhockeygame.exception.TeamNotFoundException;
import com.maplr.testhockeygame.mapper.PlayerMapper;
import com.maplr.testhockeygame.mapper.TeamMapper;
import com.maplr.testhockeygame.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/team")
public class TeamController {

	private final TeamService teamService;
	private final PlayerMapper playerMapper;
	private final TeamMapper teamMapper;

	public TeamController(final TeamService teamService,
			final PlayerMapper playerMapper,
			final TeamMapper teamMapper) {
		this.teamService = teamService;
		this.playerMapper = playerMapper;
		this.teamMapper = teamMapper;
	}

	// Memo: error found on the exercice-maplr.postman_collection.json
	// expected response code 201 or 202 but should be 200
	@GetMapping(value = "/{year}", produces = {"application/json"})
	public TeamDto getTeamByYear(@PathVariable long year) {
		return this.teamService.getTeamByYear(year)
				.map(this.teamMapper::TeamEntityToDto)
				.orElseThrow(TeamNotFoundException.forYear(year));
	}

	@PostMapping(value = "/{year}", produces = {"application/json"})
	public ResponseEntity<PlayerDto> addPlayerToTeamOnGivenYear(@PathVariable int year, @RequestBody PlayerDto playerdto) {
		PlayerEntity newPlayer = this.teamService.addTeamPlayer(year, playerdto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(this.playerMapper.playerEntityToDto(newPlayer));
	}
}
