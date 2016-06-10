package org.hft.databases.project.ejb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hft.databases.project.entity.Category;

@Stateless
public class CategoryEJB implements CategoryEJBLocal {

	@PersistenceContext(unitName = "hft-db-project-quiz")
	private EntityManager entityManager;

	public Category createNewCategory(Category category) {
		entityManager.persist(category);

		return category;
	}

	public List<Category> getAllCategory() {
		List<Category> categoryList = castList(Category.class, entityManager.createQuery("SELECT q FROM Category q").getResultList());

		return categoryList;
	}

	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
		List<T> r = new ArrayList<T>(c.size());
		for (Object o: c) {
			r.add(clazz.cast(o));
		}
		return r;
	}
}
