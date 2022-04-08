package com.maplr.testhockeygame.entity;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PLAYER")
public class PlayerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long number;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String lastname;

	@Column(nullable = false)
	private String position;

	@ManyToOne(fetch = FetchType.LAZY)
	private TeamEntity team;

	public boolean isCaptain(){
		return Optional.ofNullable(this.getTeam().getCaptain())
				.map(PlayerEntity::getId)
				.map(teamCaptainId -> teamCaptainId.equals(this.getId()))
				.orElse(false);
	}
}
