package ru.test.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.test.models.User;

@Service
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "login empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "password empty");
		ValidationUtils.rejectIfEmpty(errors, "firstName", "name empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "surname empty");
		User user = (User)o;
		if (user.getName().length() > 12 || user.getName().length() < 4) {
			errors.rejectValue("name", "wrong length");
		}
	}
}
