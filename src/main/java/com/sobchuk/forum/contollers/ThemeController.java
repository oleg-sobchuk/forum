package com.sobchuk.forum.contollers;

import com.sobchuk.forum.dao.CommentDAO;
import com.sobchuk.forum.dao.ThemeDAO;
import com.sobchuk.forum.dao.TopicDAO;
import com.sobchuk.forum.exceptions.ResourceNotFoundException;
import com.sobchuk.forum.models.Theme;
import com.sobchuk.forum.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(value = "/themes/")
public class ThemeController {

    @Autowired
    private TopicDAO topicDAO;

    @Autowired
    private ThemeDAO themeDAO;

    @PostMapping(value = "createTheme")
    public String createTheme(@Valid @RequestParam("name")String name){

        String userName = getPrincipal();
        Theme theme = new Theme(name, userName);
        themeDAO.save(theme);
        return "redirect:/";
    }

    @GetMapping(value = "createTheme")
    public String createThemePage(@ModelAttribute Theme theme){
        return "/themes/createTheme";
    }

    @GetMapping(value = "{id}")
    public String showThemeTopics(@PathVariable Long id, Model model){
        Optional<Theme> theme = themeDAO.findById(id);
        if(theme.isPresent()){
            model.addAttribute("theme",theme.get());
        }else{
            //model.addAttribute("error", "ThemeId "+id+" not found");
            return "redirect:/";
        }
        List<Topic> topics = topicDAO.findAllByThemeId(id);
        model.addAttribute("topics",topics);
        return "/themes/themeContent";
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
