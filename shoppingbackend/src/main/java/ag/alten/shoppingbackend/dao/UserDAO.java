package ag.alten.shoppingbackend.dao;

import java.util.List;

import ag.alten.shoppingbackend.dto.Address;
import ag.alten.shoppingbackend.dto.Cart;
import ag.alten.shoppingbackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	
	User getByEmail(String email);
	
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> getShippingList(User user);
	
	
	boolean updateCart(Cart cart);

}
