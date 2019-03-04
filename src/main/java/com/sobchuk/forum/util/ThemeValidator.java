package com.sobchuk.forum.util;

import com.sobchuk.forum.dao.ThemeDAO;
import com.sobchuk.forum.models.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ThemeValidator implements Validator {

    @Autowired
    private ThemeDAO themeDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return Theme.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Theme theme = (Theme) o;
        if (themeDAO.findByName(theme.getName()) != null){
            errors.rejectValue("name", "", "this theme already exist");
        }
    }
}
