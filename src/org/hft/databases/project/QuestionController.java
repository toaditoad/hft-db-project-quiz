package org.hft.databases.project;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


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

	public String createNewQuestion() {
		question.setAnswer01description("ans01");
		question.setAnswer01id("ans01id");
		question.setAnswer02description("ans02");
		question.setAnswer02id("ans02id");
		question.setAnswer03description("ans03");
		question.setAnswer03id("ans03id");
		question.setAnswer04description("ans04");
		question.setAnswer04id("ans04id");
		question.setCorrectAnswer("ans01id");
		question = questionEJB.createNewQuestion(question);
		
		return "success";
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}