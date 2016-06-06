package org.hft.databases.project.ejb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hft.databases.project.entity.Question;

@Stateless
public class QuestionEJB implements QuestionEJBLocal {

	@PersistenceContext(unitName = "hft-db-project-quiz")
	private EntityManager entityManager;

	public Question createNewQuestion(Question question) {
		entityManager.persist(question);

		return question;
	}

	public List<Question> getAllQuestions() {
		List<Question> questionList = castList(Question.class, entityManager.createQuery("SELECT q FROM Question q").getResultList());

		return questionList;
	}

	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
		List<T> r = new ArrayList<T>(c.size());
		for (Object o: c) {
			r.add(clazz.cast(o));
		}
		return r;
	}
}