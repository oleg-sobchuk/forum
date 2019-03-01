package com.sobchuk.forum.contollers;

import com.sobchuk.forum.dao.CommentDAO;
import com.sobchuk.forum.dao.TopicDAO;
import com.sobchuk.forum.dao.UserDAO;
import com.sobchuk.forum.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Map;

@Controller
public class ForumController {

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private TopicDAO topicDAO;

    @Autowired
    private UserDAO userDAO;

    //@SuppressWarnings("unchecked")
    @GetMapping(value = "/")
    public String home(Model model){
        System.out.println("im here");
        User user = new User("mee","passss","asdad@adad");
        //user.setId(33);

        userDAO.save(user);
        model.addAttribute("users",userDAO.findAll());
        System.out.println(userDAO.findAll());
        System.out.println(commentDAO.findAll());
        model.addAttribute("comments", commentDAO.findAll());
        //model.addAttribute("topics",topicDAO.findAll());
        return "index";
    }
}
