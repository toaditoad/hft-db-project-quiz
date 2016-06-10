package org.hft.databases.project.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.hft.databases.project.ejb.QuestionEJBLocal;
import org.hft.databases.project.ejb.ScoreEJBLocal;
import org.hft.databases.project.entity.Category;
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

	private Category chosenCategory;
	private int countAnsweredQuestions = 0;
	private String selectedAnswer;
	private String ctrlMessage;
	private String gameEndedMessage;

	@PostConstruct
	public void init() {
		this.score = new SingleScore();

		this.questions = questionEJB.getAllQuestions();

	}

	public Question getNextQuestion(int index) {
		Question q = this.questions.get(index);
		return q;
	}

	public void chooseCategory(Category category) {
		this.questions = questionEJB.getQuestionsByCategory(category);

		setChosenCategory(category);

		if (this.questions.size() > 0) {
			setCtrlMessage(null);
			Collections.shuffle(this.questions);
			this.currentQuestion = getNextQuestion(this.countAnsweredQuestions);
		} else {
			setCtrlMessage("There are no questions in the database of category " + category + ".");
		}

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("playQuiz.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void evaluateAnswer() {
		if (this.selectedAnswer.equals(this.currentQuestion.getCorrectAnswer())) {
			System.out.println("success");
			this.countAnsweredQuestions++;
			if (this.countAnsweredQuestions < this.questions.size()) {
				this.setSelectedAnswer("");
				this.currentQuestion = getNextQuestion(this.countAnsweredQuestions);
			} else {
				setGameEndedMessage("The game has ended. There are no questions left in this category.");
				prepareSaveScore();
			}
		} else {
			setGameEndedMessage("Your answer was not correct.");
			prepareSaveScore();
		}
	}

	public void prepareSaveScore() {
		this.score.setScore(this.countAnsweredQuestions);
		this.score.setScoreDate(new Date());
		this.score.setCategoryId(getChosenCategory());

		setCtrlMessage(null);

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("saveScore.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveScore() {
		this.score = scoreEJB.saveScore(this.score);
		setCtrlMessage(this.score.getName() + ", you successfully stored your score of " + this.score.getScore() + ".");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	public Question getCurrentQuestion() {
		return this.currentQuestion;
	}

	public Category getChosenCategory() {
		return chosenCategory;
	}

	public void setChosenCategory(Category chosenCategory) {
		this.chosenCategory = chosenCategory;
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

	public String getCtrlMessage() {
		return ctrlMessage;
	}

	public void setCtrlMessage(String ctrlMessage) {
		this.ctrlMessage = ctrlMessage;
	}

	public String getGameEndedMessage() {
		return gameEndedMessage;
	}

	public void setGameEndedMessage(String gameEndedMessage) {
		this.gameEndedMessage = gameEndedMessage;
	}
}