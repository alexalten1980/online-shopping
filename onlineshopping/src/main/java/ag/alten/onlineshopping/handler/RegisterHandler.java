package ag.alten.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import ag.alten.onlineshopping.model.RegisterModel;
import ag.alten.shoppingbackend.dao.UserDAO;
import ag.alten.shoppingbackend.dto.Address;
import ag.alten.shoppingbackend.dto.Cart;
import ag.alten.shoppingbackend.dto.User;

@Component
public class RegisterHandler {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public RegisterModel init(){
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel register, User user){
		register.setUser(user);
	}
	
	public void addBilling(RegisterModel register, Address billing){
		register.setAddress(billing);
	}
	
	public String saveAll(RegisterModel register){
		String returnValue = "succ";
		
		User user = register.getUser();
		
		if(user.getRole().equals("USER")){
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		//codifica password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		userDao.addUser(user);
		
		Address billing = register.getAddress();
		billing.setUser(user);
		billing.setBilling(true);
		
		userDao.addAddress(billing);
		
		return returnValue;
	}
	
	public String validateUser(User user, MessageContext errors){
		String esito="succ";
		
		if(!user.getPassword().equals(user.getConfirmPassword())){
			errors.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("Conferma password non coincide con la password")
					.build());	
			esito="fail";
		}
		
		if(userDao.getByEmail(user.getEmail())!=null){
			errors.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("Email già esistente")
					.build());
			esito="fail";
		}
		
		return esito;
	}
	
}
