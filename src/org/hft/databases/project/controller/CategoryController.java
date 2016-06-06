package org.hft.databases.project.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.hft.databases.project.ejb.CategoryEJBLocal;
import org.hft.databases.project.entity.Category;

@Named
@RequestScoped
public class CategoryController implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private CategoryEJBLocal categoryEJB;


	private Category category;
	private List<Category> categories;

	@PostConstruct
	public void init() {
		category = new Category();
		this.categories = categoryEJB.getAllCategory();
	}

	public void createNewCategory() {
		category = categoryEJB.createNewCategory(category);
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}

