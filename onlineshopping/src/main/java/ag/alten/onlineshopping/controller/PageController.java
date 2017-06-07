package ag.alten.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "Welcome to Spring Web MVC");

		return mv;

	}

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
