package ag.alten.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ag.alten.shoppingbackend.dao.CategoryDAO;
import ag.alten.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("ag.alten.shoppingbackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	// test add category
	/*
	 * @Test public void testAddCategory(){ category = new Category();
	 * 
	 * category.setNome("LAPTOP");
	 * category.setDescrizione("descrizione LAPTOP");
	 * category.setImageUrl("CAT_2.png");
	 * 
	 * assertEquals("Aggiunta categoria alla tabella", true,
	 * categoryDAO.add(category)); }
	 */

//	@Test
//	public void testGetCategory() {
//		category = categoryDAO.get(1);
//		System.out.println("test testGetCategory");
//		assertEquals("check getCategory", "TV", category.getNome());
//	}
//
//	@Test
//	public void testUpdateCategory() {
//		category = categoryDAO.get(2);
//		category.setNome("NOTEBOOK");
//		System.out.println("test testUpdateCategory");
//		assertEquals("check update category successfull", true, categoryDAO.update(category));
//	}
//
//	@Test
//	public void testDeleteCategory() {
//		category = categoryDAO.get(2);
//		System.out.println("test testDeleteCategory");
//		assertEquals("check delete category successfull", true, categoryDAO.delete(category));
//	}
//
//	@Test
//	public void testListCategory() {
//		System.out.println("test testListCategory");
//		assertEquals("check list category successfull", 1, categoryDAO.list().size());
//	}

//	@Test
//	public void testCRUD() {
//		
//		//test add
//		category = new Category();
//
//		category.setNome("TELEVISION");
//		category.setDescrizione("descrizione TELEVISION");
//		category.setImageUrl("CAT_1.png");
//
//		assertEquals("Aggiunta categoria alla tabella", true, categoryDAO.add(category));
//		
//		category = new Category();
//
//		category.setNome("LAPTOP");
//		category.setDescrizione("descrizione LAPTOP");
//		category.setImageUrl("CAT_2.png");
//
//		assertEquals("Aggiunta categoria alla tabella", true, categoryDAO.add(category));
//		
//		//test update and get
//		category = categoryDAO.get(2);
//		category.setNome("NOTEBOOK");
//		System.out.println("test testUpdateCategory");
//		assertEquals("check update category successfull", true, categoryDAO.update(category));
//
//		//test delete
//		System.out.println("test testDeleteCategory");
//		assertEquals("check delete category successfull", true, categoryDAO.delete(category));
//		
//		//test list
//		System.out.println("test testListCategory");
//		assertEquals("check list category successfull", 1, categoryDAO.list().size());
//	}

}
