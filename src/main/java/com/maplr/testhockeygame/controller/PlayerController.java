package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.exception.PlayerNotFoundException;
import com.maplr.testhockeygame.mapper.PlayerMapper;
import com.maplr.testhockeygame.service.PlayerService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

	private final PlayerService playerService;
	private final PlayerMapper playerMapper;

	public PlayerController( final PlayerService playerService, final PlayerMapper playerMapper) {
		this.playerService = playerService;
		this.playerMapper = playerMapper;
	}

	// Memo: PATCH should be more appropriate (partial resource update)
	// Memo 2: this endpoint is confusing, using ID to change team captain but
	// player ID is never send throw the API or mentioned.
	@PutMapping(value = "/captain/{id}", produces = {"application/json"})
	public PlayerDto updateTeamCaptain(@PathVariable long id) {
		return this.playerService.getPlayer(id)
				.map(this.playerService::updateCaptain)
				.map(this.playerMapper::playerEntityToDto)
				.orElseThrow(PlayerNotFoundException.withId(id));
	}

}
