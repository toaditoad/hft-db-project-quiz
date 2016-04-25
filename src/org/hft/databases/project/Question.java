package org.hft.databases.project;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "QUESTION")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "questionDescription")
	private String questionDescription;

	@Column(name = "answer01id")
	private String answer01id;

	@Column(name = "answer01description")
	private String answer01description;

	@Column(name = "answer02id")
	private String answer02id;

	@Column(name = "answer02description")
	private String answer02description;

	@Column(name = "answer03id")
	private String answer03id;

	@Column(name = "answer03description")
	private String answer03description;

	@Column(name = "answer04id")
	private String answer04id;

	@Column(name = "answer04description")
	private String answer04description;

	@Column(name = "correctAnswer")
	private String correctAnswer;
	
	public Question() {
		super();
	}
	
	public Question(String questionDescription) {
		super();
		this.questionDescription = questionDescription;
	}

	public Question(int id, String questionDescription, String answer01id, String answer01description,
		String answer02id, String answer02description, String answer03id, String answer03description,
		String answer04id, String answer04description, String correctAnswer) {
		super();
		this.id = id;
		this.questionDescription = questionDescription;
		this.answer01id = answer01id;
		this.answer01description = answer01description;
		this.answer02id = answer02id;
		this.answer02description = answer02description;
		this.answer03id = answer03id;
		this.answer03description = answer03description;
		this.answer04id = answer04id;
		this.answer04description = answer04description;
		this.correctAnswer = correctAnswer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public String getAnswer01id() {
		return answer01id;
	}

	public void setAnswer01id(String answer01id) {
		this.answer01id = answer01id;
	}

	public String getAnswer01description() {
		return answer01description;
	}

	public void setAnswer01description(String answer01description) {
		this.answer01description = answer01description;
	}

	public String getAnswer02id() {
		return answer02id;
	}

	public void setAnswer02id(String answer02id) {
		this.answer02id = answer02id;
	}

	public String getAnswer02description() {
		return answer02description;
	}

	public void setAnswer02description(String answer02description) {
		this.answer02description = answer02description;
	}

	public String getAnswer03id() {
		return answer03id;
	}

	public void setAnswer03id(String answer03id) {
		this.answer03id = answer03id;
	}

	public String getAnswer03description() {
		return answer03description;
	}

	public void setAnswer03description(String answer03description) {
		this.answer03description = answer03description;
	}

	public String getAnswer04id() {
		return answer04id;
	}

	public void setAnswer04id(String answer04id) {
		this.answer04id = answer04id;
	}

	public String getAnswer04description() {
		return answer04description;
	}

	public void setAnswer04description(String answer04description) {
		this.answer04description = answer04description;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
}
