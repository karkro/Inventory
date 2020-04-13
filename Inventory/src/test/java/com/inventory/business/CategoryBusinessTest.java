package com.inventory.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.inventory.dao.Category;
import com.inventory.dao.GeneralDAO;

public class CategoryBusinessTest {

	private GeneralDAO dao;
	private CategoryBusiness business;
	
	@Before
	public void setUp() throws Exception {
		dao = new GeneralDAO();
		dao.connect();
		business = new CategoryBusiness(dao);
	}

	@After
	public void tearDown() throws Exception {
		dao.close();
	}

	@Test
	public void testListAll() {
		List<Category> listCategory = business.listAll();
		assertFalse(listCategory.isEmpty());
	}
	
	@Test
	public void testSave() {
		Category newCat = new Category("Health Care");
		List<Category> listCategory = business.listAll();
		int sizeBefore = listCategory.size();
		business.save(newCat);
		
		listCategory = business.listAll();
		int sizeAfter = listCategory.size();
		
		assertTrue(sizeAfter == sizeBefore + 1);
	}
	
	@Test
	public void testDelete() {
		Category cat = new Category(3, "Electronic");
		business.delete(cat);
		assertTrue(true);
	}

}
