package org.hft.databases.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vhighscore")
public class RankedScore extends Score {

	private static final long serialVersionUID = 1L;

	@Column(name = "ranking")
	private int ranking;

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
}
