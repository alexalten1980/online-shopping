package ag.alten.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ag.alten.shoppingbackend.dao.ProductDAO;
import ag.alten.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Product get(int productId) {
		try {
			return sessionFactory.getCurrentSession()
					.get(Product.class, Integer.valueOf(productId));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> list() {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product", Product.class).getResultList();
	}

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean delete(Product product) {
		try {
			product.setActive(false);
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		String activeList = "FROM Product WHERE active = :active";
		return sessionFactory.getCurrentSession()
				.createQuery(activeList, Product.class)
				.setParameter("active", true)
				.getResultList();
	}

	@Override
	public List<Product> listProductByCategory(int category) {
		List<Product> listaProdotti;
		listaProdotti = new ArrayList();
		String activeListCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId";
		listaProdotti = sessionFactory.getCurrentSession()
				.createQuery(activeListCategory, Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", category)
				.getResultList();
		return listaProdotti;
	}

	@Override
	public List<Product> listLatestActiveProducts(int count) {
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product WHERE active = :active ORDER BY id", Product.class)
				.setParameter("active", true)
				.setFirstResult(0)
				.setMaxResults(count)
				.getResultList();
	}

}
