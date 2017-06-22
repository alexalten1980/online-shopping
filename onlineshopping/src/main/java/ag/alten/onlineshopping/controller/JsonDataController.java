package ag.alten.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ag.alten.shoppingbackend.dao.ProductDAO;
import ag.alten.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	ProductDAO productDao;
	
	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getListProduct(){

		return productDao.listActiveProducts();
	
	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getListByCategory(@PathVariable("id") int id){
		
		return productDao.listProductByCategory(id);
		
	}
	
	
	
	
	
	
}
