package org.hft.databases.project.ejb;

import java.util.List;

import org.hft.databases.project.entity.Question;

public interface QuestionEJBLocal {

	public Question createNewQuestion(Question question);

	public List<Question> getAllQuestions();

}
