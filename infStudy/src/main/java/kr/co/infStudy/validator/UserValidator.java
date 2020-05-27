package kr.co.infStudy.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import kr.co.infStudy.model.UsersVO;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UsersVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UsersVO usersVo = (UsersVO) target;

		String beanName = errors.getObjectName();
		System.out.println(beanName);
		if ("regUserVO".equals(beanName)) {
			if (usersVo.getPassword().equals(usersVo.getPasswordChk()) == false) {
				errors.rejectValue("password", "NotEquals");
				errors.rejectValue("passwordChk", "NotEquals");
			}
			if (usersVo.isEmailExist() == false) {
				errors.rejectValue("email", "DidntCheckEmailExist");
			}
		}
	}

}
