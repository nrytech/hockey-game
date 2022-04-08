package com.maplr.testhockeygame.repository;

import java.util.Optional;

import com.maplr.testhockeygame.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository  extends JpaRepository<TeamEntity, Long> {

	Optional<TeamEntity> findByYear(long year);
}
