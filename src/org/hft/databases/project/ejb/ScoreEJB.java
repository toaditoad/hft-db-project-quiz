package org.hft.databases.project.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hft.databases.project.entity.Score;

@Stateless
public class ScoreEJB implements ScoreEJBLocal {

	@PersistenceContext(unitName = "hft-db-project-quiz")
	private EntityManager entityManager;

	public Score saveScore(Score score) {
		entityManager.persist(score);
		return score;
	}

}
