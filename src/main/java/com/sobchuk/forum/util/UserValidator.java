package com.sobchuk.forum.util;

import com.sobchuk.forum.dao.UserDAO;
import com.sobchuk.forum.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (userDAO.findByEmail(user.getEmail()) != null){
            errors.rejectValue("email", "", "email already using");
        }
        if (userDAO.findByName(user.getName()) != null){
            errors.rejectValue("name", "", "name already using");
        }
    }
}
