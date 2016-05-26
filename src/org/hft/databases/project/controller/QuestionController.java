package org.hft.databases.project.controller;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.hft.databases.project.ejb.QuestionEJBLocal;
import org.hft.databases.project.entity.Question;

@Named
@RequestScoped
public class QuestionController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private QuestionEJBLocal questionEJB;

	private Question question;

	@PostConstruct
	public void init() {
		question = new Question();
	}

	public void createNewQuestion() {
		question = questionEJB.createNewQuestion(question);
	}
	
	public String getTestDatabase() {
		String result = questionEJB.testDatabase();
		
		return result;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}