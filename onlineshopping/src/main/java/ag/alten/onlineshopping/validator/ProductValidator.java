package ag.alten.onlineshopping.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ag.alten.shoppingbackend.dto.Product;

@Component
public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Product.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Product prodotto = (Product) target;

		if (prodotto.getFile() == null || prodotto.getFile().getOriginalFilename().equals("")) {
			errors.rejectValue("file", null, "Nessun file selezionato");
			return;
		}
		if (!(prodotto.getFile().getContentType().equals("image/jpg")
				|| prodotto.getFile().getContentType().equals("image/gif")
				|| prodotto.getFile().getContentType().equals("image/png"))) {

			errors.rejectValue("file", null, "formato file non compatibile");
			return;
		}
	}

}
