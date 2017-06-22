package ag.alten.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException(){
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Pagina non disponibile");
		
		mv.addObject("description", "Errore in fase di caricamento pagina, riprovare");
		
		mv.addObject("title", "404 Error Page");
		
		return mv;
		
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView productNotFoundException(){
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Prodotto non disponibile");
		
		mv.addObject("description", "Errore in fase di caricamento pagina, riprovare");
		
		mv.addObject("title", "Product Error");
		
		return mv;
		
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView productNotFoundException(Exception e){
		
		ModelAndView mv = new ModelAndView("error");
		
		//da utilizzare solo in debug mode, restituisce a video l'output della console
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		e.printStackTrace(pw);
		
		mv.addObject("errorTitle", "Contatta l'amministratore");
		
		mv.addObject("description", sw.toString());
		
		mv.addObject("title", "Errore Generico");
		
		return mv;
		
	}
	
}
