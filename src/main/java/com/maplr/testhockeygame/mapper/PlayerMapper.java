package com.maplr.testhockeygame.mapper;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.entity.PlayerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface  PlayerMapper {

	@Mapping(target="isCaptain", expression = "java(playerEntity.isCaptain())")
	PlayerDto playerEntityToDto(PlayerEntity playerEntity);

	PlayerEntity playerDtoToEntity(PlayerDto playerDto);

}
