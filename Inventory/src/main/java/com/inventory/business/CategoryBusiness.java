package com.inventory.business;

import java.util.List;

import com.inventory.dao.Category;
import com.inventory.dao.GeneralDAO;

public class CategoryBusiness {

	private GeneralDAO dao;
	
	public CategoryBusiness(GeneralDAO dao) {
		this.dao = dao;
	}
	
	public List<Category> listAll() {
		return (List<Category>) dao.list(Category.class);
	}
	
	public void save(Category cat) {
		
	}
	
	public void delete(Category cat) {
		
	}
}
