package ag.alten.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ag.alten.onlineshopping.util.FileUploadUtility;
import ag.alten.onlineshopping.validator.ProductValidator;
import ag.alten.shoppingbackend.dao.CategoryDAO;
import ag.alten.shoppingbackend.dao.ProductDAO;
import ag.alten.shoppingbackend.dto.Category;
import ag.alten.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private ProductValidator productValidator;

	private final static Logger logger = LoggerFactory.getLogger(ManagementController.class);

	// @InitBinder
	// protected void initBinder(WebDataBinder binder) {
	// binder.setValidator(productValidator);
	// }

	// vista pagina per gestione prodotto
	@RequestMapping("/products")
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Manage Products");
		mv.addObject("userClickManageProducts", true);

		Product nProduct = new Product();
		nProduct.setActive(true);
		nProduct.setSupplierId(1);

		if (operation != null) {
			if ("product".equals(operation)) {
				mv.addObject("message", "Prodotto Inserito con Successo!");
			}
			if ("category".equals(operation)) {
				mv.addObject("message", "Categoria Inserita con Successo!");
			}
		}

		mv.addObject("product", nProduct);

		return mv;
	}

	@RequestMapping(value = "/{id}/product", method = RequestMethod.GET)
	public ModelAndView getSingleProduct(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Manage Products");
		mv.addObject("userClickManageProducts", true);

		Product nProduct = productDAO.get(id);

		mv.addObject("product", nProduct);

		return mv;
	}

	// inserimento o modifica prodotto
	// httpServletRequest necessario per l'upload di file
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product prodotto, BindingResult result,
			Model model, HttpServletRequest request) {
		
		//nuovo prodotto
		if (prodotto.getId() == 0) {
			new ProductValidator().validate(prodotto, result);
		} else {
			//modifica prodotto, controlla se è presente il nome del file
			if(!prodotto.getFile().getOriginalFilename().equals("")){
				new ProductValidator().validate(prodotto, result);
			}
		}
		
		if (result.hasErrors()) {
			model.addAttribute("user", "Manage Products");
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("message", "Inserimento non riuscito, riprovare");

			return "page";
		}

		logger.info(prodotto.toString());
		
		//nuovo prodotto
		if (prodotto.getId() == 0) {
			productDAO.add(prodotto);
		} else { //modifica prodotto
			productDAO.update(prodotto);
		}

		if (!prodotto.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, prodotto.getFile(), prodotto.getCode());
		}

		return "redirect:/manage/products?operation=product";
	}

	// setting attributo combo box categorie
	@ModelAttribute(name="categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}

	// cambio stato record da datatables
	@RequestMapping(value = "/product/{id}/state", method = RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		Product product = productDAO.get(id);
		boolean state = product.isActive();

		product.setActive(!product.isActive());
		productDAO.update(product);

		return (state) ? "Il prodotto " + product.getName() + " è ora deattivo"
				: "Il prodotto " + product.getName() + " è ora attivo";
	}
	
	@ModelAttribute("category")
	public Category modelCategory(){
		return new Category();
	}
	
	@RequestMapping(value = "/category", method=RequestMethod.POST)
	public String handleCategory(@ModelAttribute("category") Category categoria){
		categoryDAO.add(categoria);
		
		return "redirect:/manage/products?operation=category";
	}

}
