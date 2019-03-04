package com.sobchuk.forum.contollers;

import com.sobchuk.forum.dao.ThemeDAO;
import com.sobchuk.forum.dao.TopicDAO;
import com.sobchuk.forum.models.Theme;
import com.sobchuk.forum.models.Topic;
import com.sobchuk.forum.util.ThemeValidator;
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
public class ThemeController {

    @Autowired
    private TopicDAO topicDAO;

    @Autowired
    private ThemeDAO themeDAO;

    @Autowired
    private ThemeValidator themeValidator;

    @PostMapping(value = "createTheme")
    public String createTheme(@Valid @ModelAttribute Theme theme, BindingResult result, Model model){
        themeValidator.validate(theme,result);
        if (result.hasErrors()){
            model.addAttribute("theme", new Theme());
            return "/themes/createTheme";
        }
        String userName = getPrincipal();
        Theme newTheme = new Theme(theme.getName(), userName);
        themeDAO.save(newTheme);
        return "redirect:/";
    }

    @GetMapping(value = "createTheme")
    public String createThemePage(Model model){
        model.addAttribute("theme",new Theme());
        return "/themes/createTheme";
    }

    @GetMapping(value = "{id}/deleteTheme")
    public String deleteTheme(@PathVariable Long id){
        themeDAO.deleteById(id);
        return "redirect:/";
    }

    @GetMapping(value = "{id}")
    public String showThemeTopics(@PathVariable Long id, Model model){
        Optional<Theme> theme = themeDAO.findById(id);
        if(theme.isPresent()){
            model.addAttribute("theme",theme.get());
        }else{
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
