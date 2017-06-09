package ag.alten.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ag.alten.shoppingbackend.dao.CategoryDAO;
import ag.alten.shoppingbackend.dto.Category;

@Controller
public class PageController {
	
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		
		//passo la lista di categorie
		mv.addObject("categorie", categoryDAO.list());

		return mv;
	}
	
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		
		//passo la lista di categorie
		mv.addObject("categorie", categoryDAO.list());

		return mv;
	}
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		Category categoria = null;
		
		//prende una categoria singola
		categoria = categoryDAO.get(id);
	
		mv.addObject("title", categoria.getNome());
		
		//passo la lista di categorie
		mv.addObject("categorie", categoryDAO.list());
		
		//passo una singola categoria
		mv.addObject("categoria", categoria);
		
		mv.addObject("userClickCategoryProducts", true);

		return mv;
	}
	
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);

		return mv;
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);

		return mv;
	}

//	@RequestMapping(value = { "/", "/home", "/index" })
//	public ModelAndView index() {
//
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting", "Welcome to Spring Web MVC");
//
//		return mv;
//
//	}

//	@RequestMapping(value="/test")
//	public ModelAndView test(@RequestParam(value="valpath", required=false) String valpath){
//		
//		if(valpath == null){
//			valpath=" ciaoooo!!! ";
//		}
//		
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting", valpath);
//		
//		return mv;
//		
//	}
//	
//	@RequestMapping(value="/testpathvar/{nome}")
//	public ModelAndView testPathVariable(@PathVariable(value="nome") String valpathvar){
//		
//		if(valpathvar == null){
//			valpathvar=" ciaoooo!!! ";
//		}
//		
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("greeting", valpathvar);
//		
//		return mv;
//		
//	}
	
	

}
