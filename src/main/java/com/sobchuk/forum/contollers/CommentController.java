package com.sobchuk.forum.contollers;

import com.sobchuk.forum.dao.CommentDAO;
import com.sobchuk.forum.dao.ThemeDAO;
import com.sobchuk.forum.dao.TopicDAO;
import com.sobchuk.forum.models.Comment;
import com.sobchuk.forum.models.Theme;
import com.sobchuk.forum.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/themes/")
public class CommentController {

    @Autowired
    private CommentDAO commentDAO;

    @Autowired
    private TopicDAO topicDAO;

    @Autowired
    private ThemeDAO themeDAO;

    @PostMapping(value = "{themeId}/{topicId}/createComment")
    public String createComment(@PathVariable Long themeId, @PathVariable Long topicId, @ModelAttribute Comment comment, Model model){
        Optional<Theme> theme = themeDAO.findById(themeId);
        if(theme.isPresent()){
            Optional<Topic> topic = topicDAO.findById(topicId);
            if(topic.isPresent()){
                Comment newCommewnt = new Comment(comment.getText(),getPrincipal(),topic.get());
                commentDAO.save(newCommewnt);
                return "redirect:/themes/{themeId}/{topicId}";
            }
            return "redirect:/themes/{themeId}";
        }
        return "redirect:/";
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            userName = ((UserDetails)principal).getUsername();
        }else{
            userName = principal.toString();
        }
        return userName;
    }
}
