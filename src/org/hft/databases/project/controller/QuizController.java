package org.hft.databases.project.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.hft.databases.project.ejb.QuestionEJBLocal;
import org.hft.databases.project.ejb.ScoreEJBLocal;
import org.hft.databases.project.entity.Question;
import org.hft.databases.project.entity.SingleScore;

@Named
@SessionScoped
public class QuizController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private QuestionEJBLocal questionEJB;

	@EJB
	private ScoreEJBLocal scoreEJB;

	private Question currentQuestion;
	private List<Question> questions;
	private SingleScore score;

	private int countAnsweredQuestions = 0;
	private String selectedAnswer;

	private boolean renderSaveScoreForm = false;
	private boolean renderSaveScoreAlertSuccess = false;

	@PostConstruct
	public void init() {
		this.score = new SingleScore();
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
			this.countAnsweredQuestions++;
			if (this.countAnsweredQuestions < this.questions.size()) {
				this.setSelectedAnswer("");
				this.currentQuestion = getNextQuestion(this.countAnsweredQuestions);
			} else {
				System.out.println("no questions left");
				// redirect to store score view
				prepareSaveScore();
			}
		} else {
			System.out.println("error");
			// redirect to store score view
			prepareSaveScore();
		}
	}

	public void prepareSaveScore() {
		try {
			this.score.setScore(this.countAnsweredQuestions);
			//this.score.setScoreDate(new Date());
			this.renderSaveScoreForm = true;
			FacesContext.getCurrentInstance().getExternalContext().redirect("saveScore.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveScore() {
		this.score = scoreEJB.saveScore(this.score);
		this.renderSaveScoreForm = false;
		this.renderSaveScoreAlertSuccess = true;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	public Question getCurrentQuestion() {
		return this.currentQuestion;
	}

	public SingleScore getScore() {
		return score;
	}

	public void setScore(SingleScore score) {
		this.score = score;
	}

	public String getSelectedAnswer() {
		return this.selectedAnswer;
	}

	public void setSelectedAnswer(String selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}

	public int getCountAnsweredQuestions() {
		return this.countAnsweredQuestions;
	}

	public boolean isRenderSaveScoreForm() {
		return renderSaveScoreForm;
	}

	public boolean isRenderSaveScoreAlertSuccess() {
		return renderSaveScoreAlertSuccess;
	}
}