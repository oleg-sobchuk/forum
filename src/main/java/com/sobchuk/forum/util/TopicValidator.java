package com.sobchuk.forum.util;

import com.sobchuk.forum.dao.TopicDAO;
import com.sobchuk.forum.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TopicValidator implements Validator {

    @Autowired
    private TopicDAO topicDAO;

    @Override
    public boolean supports(Class<?> aClass) {
        return Topic.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Topic topic = (Topic) o;
        if (topicDAO.findByName(topic.getName()) != null){
            errors.rejectValue("name", "", "this topic already exist");
        }
    }
}
