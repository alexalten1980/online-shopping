package ag.alten.onlineshopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import ag.alten.onlineshopping.model.UserModel;
import ag.alten.shoppingbackend.dao.UserDAO;
import ag.alten.shoppingbackend.dto.User;

@ControllerAdvice
public class GlobalController {

	@Autowired
	HttpSession session;
	
	@Autowired
	UserDAO userDao;
	
	private UserModel userModel = null;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel(){
		System.out.println("fuori dal primo if");
		if(session.getAttribute("userModel")==null){
			//aggiungi l'utente al model
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			User user = userDao.getByEmail(authentication.getName());
			userModel = null;
			System.out.println("fuori dal secondo if");
			if(user!=null){
				userModel = new UserModel();
				
				userModel.setId(user.getId());
				userModel.setRole(user.getRole());
				System.out.println(user.toString());
				userModel.setFullName(user.getFirstName() + " " + user.getLastName());
				
				if(userModel.getRole().equals("USER")){
					//solo se è un compratore
					userModel.setCart(user.getCart());
				}
			}
			
			session.setAttribute("userModel", userModel);
			
			return userModel;
			
		}
		
		return (UserModel) session.getAttribute("userModel");
	}
	
}
