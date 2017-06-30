package ag.alten.onlineshopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ag.alten.onlineshopping.exception.ProductNotFoundException;
import ag.alten.shoppingbackend.dao.CategoryDAO;
import ag.alten.shoppingbackend.dao.ProductDAO;
import ag.alten.shoppingbackend.dto.Category;
import ag.alten.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDao;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEGUG");
		
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
	
		mv.addObject("title", categoria.getName());
		
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
	
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showProduct(@PathVariable int id) throws ProductNotFoundException {
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDao.get(id);
		
		if(product == null) throw new ProductNotFoundException();
			
		product.setViews(product.getViews() + 1);
		
		productDao.update(product);
		
		mv.addObject("title", product.getName());
		mv.addObject("prodotto", product);
		
		mv.addObject("userClickShowProduct", true);
		
		return mv;
	}
	
	@RequestMapping(value = "/register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Register");
		return mv;
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView loging(@RequestParam(value="error",required=false) String error,
			@RequestParam(value="logout",required=false) String logout) {
		ModelAndView mv = new ModelAndView("login");
		
		if (error != null) {
			mv.addObject("message", "Autenticazione non riuscita username e/o password errati");
		}
		
		if (logout != null) {
			mv.addObject("logout", "Hai effettuato il logout correttamente");
		}
		
		mv.addObject("title", "Login");
		return mv;
	}
	
	@RequestMapping(value="/errorpage")
	public ModelAndView accessDenied(){
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "Error - 404");
		mv.addObject("errorTitle", "Accesso Negato");
		mv.addObject("description", "Non sei autorizzato ad accedere");
		return mv;
	}
	
	//logout
	@RequestMapping(value="/perform-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth!=null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:login?logout";
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
