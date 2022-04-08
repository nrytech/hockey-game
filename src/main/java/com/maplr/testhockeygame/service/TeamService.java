package com.maplr.testhockeygame.service;

import java.util.Optional;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.entity.PlayerEntity;
import com.maplr.testhockeygame.entity.TeamEntity;
import com.maplr.testhockeygame.exception.TeamNotFoundException;
import com.maplr.testhockeygame.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeamService {

	private final TeamRepository teamRepository;
	private final PlayerService playerService;

	public TeamService(final TeamRepository teamRepository,
			final PlayerService playerService) {
		this.teamRepository = teamRepository;
		this.playerService = playerService;
	}

	@Transactional
	public PlayerEntity addTeamPlayer(long year, PlayerDto playerDto) {
		return this.teamRepository.findByYear(year)
				.map(team -> {
					PlayerEntity newPlayer = this.playerService.createPlayer(playerDto);
					newPlayer.setTeam(team);
					team.getPlayers().add(newPlayer);
					if (playerDto.isCaptain()) {
						team.setCaptain(newPlayer);
					}
					return newPlayer;
				}).orElseThrow(TeamNotFoundException.forYear(year));
	}

	public Optional<TeamEntity> getTeamByYear(long year) {
		return this.teamRepository.findByYear(year);
	}

}
