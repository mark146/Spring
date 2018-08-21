package org.com.validator;

import org.com.vo.*;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uid", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "upw", "required");
	}
}