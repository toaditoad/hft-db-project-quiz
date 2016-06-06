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

	private String ctrlMessage;

	@PostConstruct
	public void init() {
		question = new Question();
		setCtrlMessage(null);
	}

	public void createNewQuestion() {
		question = questionEJB.createNewQuestion(question);
		if (question != null) {
			setCtrlMessage("You successfully created a question.");
		}
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getCtrlMessage() {
		return ctrlMessage;
	}

	public void setCtrlMessage(String ctrlMessage) {
		this.ctrlMessage = ctrlMessage;
	}
}