package ag.alten.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ag.alten.shoppingbackend.dao.ProductDAO;
import ag.alten.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDao;
	
	private Product product;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("ag.alten.shoppingbackend");
		context.refresh();
		productDao = (ProductDAO) context.getBean("productDAO");
	}
	
	@Test
	public void productTestCRUD(){
		product = new Product();
		product.setName("Apple Iphone 6");
		product.setBrand("Apple");
		product.setDescription("caratteristiche tecniche dell'Iphone 6");
		product.setUnitPrice(1000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
//		assertEquals("Qualcosa di sbagliato nell'inserimento di un nuovo prodotto", 
//				true, productDao.add(product));
//		
//		product = productDao.get(2);
//		product.setName("Samsung Galaxy S7");
//		assertEquals("Qualcosa non ha funzionato in fase di modifica", true, 
//				productDao.update(product));
//		
//		assertEquals("Qualcosa non ha funzionato in fase di disabilitazione", true, 
//				productDao.delete(product));
//		
//		assertEquals("Qualcosa non ha funzionato in fase di estrazione lista attiva", 
//				6,productDao.list().size());
		
		assertEquals("Qualcosa non ha funzionato sulle liste attive", 5, 
				productDao.listActiveProducts().size());
		
		assertEquals("Qualcosa non ha funzionato sulle liste di categoria", 3, 
				productDao.listProductByCategory(3).size());
		
		assertEquals("Qualcosa non ha funzionato sulle prime liste", 3, 
				productDao.listLatestActiveProducts(3).size());
	
	}
}
