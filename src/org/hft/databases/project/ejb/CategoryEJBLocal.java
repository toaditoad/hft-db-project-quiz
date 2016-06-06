package org.hft.databases.project.ejb;

import java.util.*;

import org.hft.databases.project.entity.Category;

public interface CategoryEJBLocal {

	public Category createNewCategory(Category category);
	
	public List<Category> getAllCategory();
	
}
