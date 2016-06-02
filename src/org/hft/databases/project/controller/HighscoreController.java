package org.hft.databases.project.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.hft.databases.project.ejb.ScoreEJBLocal;
import org.hft.databases.project.entity.RankedScore;

@Named
@RequestScoped
public class HighscoreController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ScoreEJBLocal scoreEJB;

	private RankedScore[] highscores;

	@PostConstruct
	public void init() {
		this.highscores = scoreEJB.getHighscores();
	}

	public RankedScore[] getHighscores() {
		return highscores;
	}
}
