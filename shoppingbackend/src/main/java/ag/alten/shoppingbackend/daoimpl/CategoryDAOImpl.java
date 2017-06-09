package ag.alten.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ag.alten.shoppingbackend.dao.CategoryDAO;
import ag.alten.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> listCategories = new ArrayList<Category>();

	static {

		Category categoria = new Category();

		categoria.setId(1);
		categoria.setNome("TV");
		categoria.setDescrizione("descrizione tv");
		categoria.setImageUrl("CAT_1.png");

		listCategories.add(categoria);
		
		categoria = new Category();
		categoria.setId(2);
		categoria.setNome("laptop");
		categoria.setDescrizione("descrizione laptop");
		categoria.setImageUrl("CAT_2.png");

		listCategories.add(categoria);
		
		categoria = new Category();
		categoria.setId(3);
		categoria.setNome("smartphone");
		categoria.setDescrizione("descrizione smartphone");
		categoria.setImageUrl("CAT_3.png");

		listCategories.add(categoria);

	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return listCategories;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		
		for(Category cat : listCategories){
			
			if(cat.getId()==id) return cat;
			
		}
		
		return null;
	}

}
