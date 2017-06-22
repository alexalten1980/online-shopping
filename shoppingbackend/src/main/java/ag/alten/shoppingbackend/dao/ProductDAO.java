package ag.alten.shoppingbackend.dao;

import java.util.List;

import ag.alten.shoppingbackend.dto.Product;

public interface ProductDAO {
	
	Product get(int productId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	List<Product> listActiveProducts();
	List<Product> listProductByCategory(int category);
	List<Product> listLatestActiveProducts(int count);
}
