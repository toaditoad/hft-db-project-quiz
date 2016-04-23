package org.hft.databases.project;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class QuestionEJB implements QuestionEJBLocal {

	@PersistenceContext(unitName = "hft-db-project-quiz")
	private EntityManager entityManager;

	@Override
	public Question createNewQuestion(Question question) {
		entityManager.persist(question);

		return question;
	}
}