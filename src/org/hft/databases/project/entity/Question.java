package org.hft.databases.project.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;

@Entity
@Table(name = "QUESTION")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "question")
	private String question;

	@Column(name = "answer01")
	private String answer01;
	
	@Column(name = "answer02")
	private String answer02;
	
	@Column(name = "answer03")
	private String answer03;
	
	@Column(name = "answer04")
	private String answer04;

	@Column(name = "correctAnswer")
	private String correctAnswer;
	
	//@OneToOne
	@Column(name = "category_id")
	private int categoryId;
	
	
	public Question() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer01() {
		return answer01;
	}

	public void setAnswer01(String answer01) {
		this.answer01 = answer01;
	}

	public String getAnswer02() {
		return answer02;
	}

	public void setAnswer02(String answer02) {
		this.answer02 = answer02;
	}

	public String getAnswer03() {
		return answer03;
	}

	public void setAnswer03(String answer03) {
		this.answer03 = answer03;
	}

	public String getAnswer04() {
		return answer04;
	}

	public void setAnswer04(String answer04) {
		this.answer04 = answer04;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Category getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	
}
