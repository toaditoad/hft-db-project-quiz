package org.hft.databases.project.ejb;

import org.hft.databases.project.entity.RankedScore;
import org.hft.databases.project.entity.SingleScore;

public interface ScoreEJBLocal {

	public SingleScore saveScore(SingleScore score);

	public RankedScore[] getHighscores();

}
