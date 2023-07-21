package com.onlineshop.validate;

import com.onlineshop.model.User;
import com.onlineshop.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class UserValidate implements Validator {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        User user1 = iUserRepository.findByUsername(user.getUsername());
        if (user1 != null) {
            errors.rejectValue("username", "", "Username have already existed");
        }

        User user2 = iUserRepository.findByEmail(user.getEmail());
        if (user2 != null) {
            errors.rejectValue("email", "", "Email have already existed");
        }
    }
}
