package org.hft.databases.project.controller;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.hft.databases.project.ejb.QuestionEJBLocal;
import org.hft.databases.project.entity.Question;

@Named
@SessionScoped
public class QuizController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private QuestionEJBLocal questionEJB;

	private Question currentQuestion;
	private List<Question> questions;

	private int countAnsweredQuestions = 0;
	private String selectedAnswer;

	@PostConstruct
	public void init() {
		this.questions = questionEJB.getAllQuestions();
		Collections.shuffle(this.questions);

		this.currentQuestion = getNextQuestion(this.countAnsweredQuestions);
	}

	public Question getNextQuestion(int index) {
		Question q = this.questions.get(index);
		return q;
	}

	public void evaluateAnswer() {
		if (this.selectedAnswer.equals(this.currentQuestion.getCorrectAnswer())) {
			System.out.println("success");
			if (this.countAnsweredQuestions < this.questions.size() - 1) {
				this.countAnsweredQuestions++;
				this.setSelectedAnswer("");
				this.currentQuestion = getNextQuestion(this.countAnsweredQuestions);
			} else {
				System.out.println("no questions left");
				// redirect to store score view
			}
		} else {
			System.out.println("error");
			// redirect to store score view
		}
	}

	public Question getCurrentQuestion() {
		return this.currentQuestion;
	}

	public String getSelectedAnswer() {
		return this.selectedAnswer;
	}

	public void setSelectedAnswer(String selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}
}