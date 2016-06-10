package org.hft.databases.project.ejb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hft.databases.project.entity.RankedScore;
import org.hft.databases.project.entity.SingleScore;

@Stateless
public class ScoreEJB implements ScoreEJBLocal {

	@PersistenceContext(unitName = "hft-db-project-quiz")
	private EntityManager entityManager;

	public SingleScore saveScore(SingleScore score) {
		entityManager.persist(score);

		return score;
	}

	public RankedScore[] getHighscores() {
		List<RankedScore> highscoreList = castList(RankedScore.class, entityManager.createQuery("SELECT rs FROM RankedScore rs").getResultList());

		RankedScore[] highScoreArray = new RankedScore[highscoreList.size()];
		highscoreList.toArray(highScoreArray);

		return highScoreArray;
	}

	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
		List<T> r = new ArrayList<T>(c.size());
		for (Object o: c) {
			r.add(clazz.cast(o));
		}
		return r;
	}
}
