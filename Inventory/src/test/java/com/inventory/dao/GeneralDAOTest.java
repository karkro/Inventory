package com.inventory.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GeneralDAOTest {

	private GeneralDAO dao;
	
	@Before
	public void setUp() throws Exception {
		dao = new GeneralDAO();
		dao.connect();
	}
	
	@After
	public void tearDown() throws Exception {
		dao.close();
	}
	
	@Test
	public void testConnect() {
		GeneralDAO dao = new GeneralDAO();
		dao.connect();
		dao.close();
	}
	
	@Test 
	public void testSave() {
		Category cat = new Category("Electronic");
		long id = dao.save(cat);
		assertTrue(id > 0);
	}
	
	@Test
	public void testDelete() {
		Category cat = new Category(2);
		dao.delete(cat);
		assertTrue(true);
	}
	
	@Test
	public void testList() {
		List<Category> list = dao.list(Category.class);
		for (Category cat : list) {
			System.out.println(cat);
		}
		assertTrue(list.size() > 0);
	}
	
	@Test
	public void testGet() {
		long id = 1;
		Category category = dao.get(Category.class, id);
		assertNotNull(category);
	}

}
