package org.hft.databases.project;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;


@Named
@RequestScoped
public class QuestionController {

	@EJB
	private QuestionEJBLocal questionEJB;

	private Question question;

	@PostConstruct
	public void init() {
		question = new Question();
	}

	public String createNewQuestion() {
		question = questionEJB.createNewQuestion(question);
		return "question added";
	}

	public Question getQuestion() {
		return question;
	}
}
