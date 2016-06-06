package org.hft.databases.project.entity;

import javax.persistence.*;

import org.hft.databases.project.ejb.CategoryEJBLocal;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id")
	private int id;
	
	@Column(name = "categoryName")
	private String categoryName;
	
	
	
	public Category() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

 
}
