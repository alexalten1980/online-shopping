package ag.alten.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ag.alten.shoppingbackend.dao.UserDAO;
import ag.alten.shoppingbackend.dto.Address;
import ag.alten.shoppingbackend.dto.Cart;
import ag.alten.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDao;
	private User user = null;
	private Address address = null;
	private Cart cart = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("ag.alten.shoppingbackend");
		context.refresh();

		userDao = (UserDAO) context.getBean("userDAO");
	}

	// @Test
	// public void testAdd(){
	//
	// user = new User();
	//
	// user.setFistName("Alex");
	// user.setLastName("Gerax");
	// user.setEmail("ag@gmail.com");
	// user.setContactNumber("333333333");
	// user.setRole("USER");
	// user.setPassword("123456");
	//
	// assertEquals("Inserimento utente fallito", true, userDao.addUser(user));
	//
	// address = new Address();
	//
	// //indirizzo di fatturazione
	// address.setAddressLineOne("Via Milano 100, Baltimora");
	// address.setAddressLineTwo("via Gottardi 85");
	// address.setCity("Kansas City");
	// address.setState("KANSAS");
	// address.setCountry("USA");
	// address.setPostalCode("45555");
	// address.setBilling(true);
	//
	// address.setUserId(user.getId());
	//
	// assertEquals("Inserimento indirizzo fatturazione fallito", true,
	// userDao.addAddress(address));
	//
	// if(user.getRole().equals("USER")){
	//
	// cart = new Cart();
	//
	// cart.setUser(user);
	//
	// assertEquals("Inserimento cart fallito", true, userDao.addCart(cart));
	//
	// //indirizzo di vendita
	//
	// address = new Address();
	// address.setAddressLineOne("Via Milano 100, Baltimora");
	// address.setAddressLineTwo("via Gottardi 85");
	// address.setCity("Kansas City");
	// address.setState("KANSAS");
	// address.setCountry("USA");
	// address.setPostalCode("45555");
	// address.setShipping(true);
	//
	// address.setUserId(user.getId());
	//
	// assertEquals("Inserimento indirizzo vendita fallito", true,
	// userDao.addAddress(address));
	// }
	//
	// }

	// @Test
	// public void testUpdateCart(){
	//
	// user = userDao.getByEmail("ag@gmail.com");
	//
	// cart = user.getCart();
	//
	// cart.setGrandTotal(99999);
	//
	// cart.setCartLine(2);
	//
	// assertEquals("Non è stato possibile aggiornare la carta", true,
	// userDao.updateCart(cart));
	//
	//
	// }

	@Test
	public void testGetAddress() {

		user = new User();

		user.setFirstName("Alex");
		user.setLastName("Gerax");
		user.setEmail("ag@gmail.com");
		user.setContactNumber("333333333");
		user.setRole("USER");
		user.setPassword("123456");

		assertEquals("Inserimento utente fallito", true, userDao.addUser(user));

		address = new Address();

		// indirizzo di fatturazione
		address.setAddressLineOne("Via Milano 100, Baltimora");
		address.setAddressLineTwo("via Gottardi 85");
		address.setCity("Turin");
		address.setState("Italy");
		address.setCountry("Italy");
		address.setPostalCode("10100");
		address.setBilling(true);

		address.setUser(user);

		assertEquals("Inserimento indirizzo fatturazione", true, userDao.addAddress(address));

		address = new Address();
		
		// indirizzo di vendita
		address.setAddressLineOne("Via Milano 100, Baltimora");
		address.setAddressLineTwo("via Bristol 65");
		address.setCity("Kansas City");
		address.setState("KANSAS");
		address.setCountry("USA");
		address.setPostalCode("45555");
		address.setShipping(true);

		address.setUser(user);

		assertEquals("Inserimento indirizzo vendita", true, userDao.addAddress(address));
		
		address = new Address();
		
		// indirizzo di vendita
		address.setAddressLineOne("Via Milano 100, Baltimora");
		address.setAddressLineTwo("via Chiesa 5");
		address.setCity("Kansas City");
		address.setState("KANSAS");
		address.setCountry("USA");
		address.setPostalCode("45555");
		address.setShipping(true);

		address.setUser(user);
		
		assertEquals("Inserimento indirizzo vendita", true, userDao.addAddress(address));
		
		user = userDao.getByEmail("ag@gmail.com");
		
		assertEquals("Select indirizzo fatturazione fallito", "Turin", userDao.getBillingAddress(user).getCity());
	
		assertEquals("Select indirizzi vendita fallito", 2, userDao.getShippingList(user).size());
	}

}
