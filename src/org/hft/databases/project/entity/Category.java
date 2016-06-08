package org.hft.databases.project.entity;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "categoryName")
	private String categoryName;

	@Column(name = "totalNumberQuestions")
	private int totalNumberQuestions;

	@Column(name = "maxNumberCorrectlyAnsweredQuestions")
	private int maxNumberCorrectlyAnsweredQuestions;

	public Category() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalNumberQuestions() {
		return totalNumberQuestions;
	}

	public void setTotalNumberQuestions(int totalNumberQuestions) {
		this.totalNumberQuestions = totalNumberQuestions;
	}

	public int getMaxNumberCorrectlyAnsweredQuestions() {
		return maxNumberCorrectlyAnsweredQuestions;
	}

	public void setMaxNumberCorrectlyAnsweredQuestions(int maxNumberCorrectlyAnsweredQuestions) {
		this.maxNumberCorrectlyAnsweredQuestions = maxNumberCorrectlyAnsweredQuestions;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
