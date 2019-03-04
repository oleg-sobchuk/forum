package com.sobchuk.forum.contollers;

import com.sobchuk.forum.dao.CommentDAO;
import com.sobchuk.forum.dao.ThemeDAO;
import com.sobchuk.forum.dao.TopicDAO;
import com.sobchuk.forum.models.Comment;
import com.sobchuk.forum.models.Theme;
import com.sobchuk.forum.models.Topic;
import com.sobchuk.forum.util.TopicValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/themes/")
public class TopicController {

    @Autowired
    private CommentDAO commentDAO;
    @Autowired
    private TopicDAO topicDAO;
    @Autowired
    private ThemeDAO themeDAO;

    @Autowired
    private TopicValidator topicValidator;

    @PostMapping(value = "{id}/createTopic")
    public String createTopic(@PathVariable Long id, @ModelAttribute @Valid Topic topic,
                              BindingResult result, Model model){
        topicValidator.validate(topic,result);
        Optional<Theme> theme = themeDAO.findById(id);
        if(theme.isPresent()){
            if (result.hasErrors()){
                model.addAttribute("topic", new Topic());
                model.addAttribute("theme",theme.get());
                model.addAttribute("errors",result.getAllErrors());
                return "/topics/createTopic";
            }
            String userName = getPrincipal();
            Topic newTopic = new Topic(topic.getName(), topic.getDesc(), userName, theme.get());
            topicDAO.save(newTopic);
            return "redirect:/themes/{id}";
        }
        return "redirect:/";
    }

    @GetMapping(value = "{id}/createTopic")
    public String createTopicPage(@PathVariable Long id, Model model){
        Optional<Theme> theme = themeDAO.findById(id);
        if(theme.isPresent()){
            model.addAttribute("topic", new Topic());
            model.addAttribute("theme",theme.get());
            return "/topics/createTopic";
        }
        return "redirect:/";
    }

    @GetMapping(value = "{themeId}/{topicId}/deleteTopic")
    public String deleteTopic(@PathVariable Long themeId, @PathVariable Long topicId){
        topicDAO.deleteById(topicId);
        return "redirect:/themes/{themeId}";
    }

    @GetMapping(value = "{themeId}/{id}")
    public String showTopicComments(@PathVariable(value = "id") Long id,
                                    @PathVariable(value = "themeId") Long themeId, Model model){
        Optional<Topic> topic = topicDAO.findById(id);
        if(topic.isPresent()){
            model.addAttribute("topic",topic.get());
            model.addAttribute("theme", topic.get().getTheme());
        }else{
            return "redirect:/theme/{themeId}";
        }
        List<Comment> comments = commentDAO.findAllByTopicId(id);
        model.addAttribute("comments",comments);
        return "/topics/topicContent";
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

