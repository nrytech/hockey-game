package com.maplr.testhockeygame.service;

import java.util.Optional;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.entity.PlayerEntity;
import com.maplr.testhockeygame.mapper.PlayerMapper;
import com.maplr.testhockeygame.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerService {

	private final PlayerRepository playerRepository;
	private final PlayerMapper playerMapper;

	public PlayerService(final PlayerRepository playerRepository, final PlayerMapper playerMapper) {
		this.playerRepository = playerRepository;
		this.playerMapper = playerMapper;
	}

	public Optional<PlayerEntity> getPlayer(long playerId) {
		return this.playerRepository.findById(playerId);
	}

	@Transactional
	public PlayerEntity createPlayer(final PlayerDto playerDto) {
		return this.playerRepository.save(this.playerMapper.playerDtoToEntity(playerDto));
	}

	@Transactional
	public PlayerEntity updateCaptain(PlayerEntity newCaptain){
		newCaptain.getTeam().setCaptain(newCaptain);
		return newCaptain;
	}
}
