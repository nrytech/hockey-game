package com.maplr.testhockeygame.mapper;

import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.entity.TeamEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = PlayerMapper.class)
public interface TeamMapper {

	TeamDto TeamEntityToDto(TeamEntity teamEntity);

	TeamEntity TeamDtoToEntity(TeamDto teamDto);

}
