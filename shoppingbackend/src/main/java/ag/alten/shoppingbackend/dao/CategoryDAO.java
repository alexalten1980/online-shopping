package ag.alten.shoppingbackend.dao;

import java.util.List;

import ag.alten.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	public List<Category> list();
	
	public Category get(int id);
	
	boolean add(Category category);
	
	boolean update(Category category);
	
	boolean delete(Category category);
	
}
