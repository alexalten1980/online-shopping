package ag.alten.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ag.alten.shoppingbackend.dao.CategoryDAO;
import ag.alten.shoppingbackend.dto.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	private static List<Category> listCategories = new ArrayList<Category>();

	/*static {

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

	}*/

	/*@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return listCategories;
	}*/

	/*@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		
		for(Category cat : listCategories){
			
			if(cat.getId()==id) return cat;
			
		}
		
		return null;
	}*/
	
	public Category get(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}
	
	//persist non restituisce l'id, save sì, solitamente è utilizzato persist, save fa
	//l'insert indipendentemente se sei fuori o dentro la transazione
	@Override
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	//update controlla lo stato della sessione merge no
	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Category> list() {
		
		String queryString = "from Category where active=:active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		
		query.setParameter("active", true);

		return query.getResultList();
	}

}
