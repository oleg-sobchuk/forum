package com.sobchuk.forum.contollers;

import com.sobchuk.forum.dao.ThemeDAO;
import com.sobchuk.forum.dao.UserDAO;
import com.sobchuk.forum.models.User;
import com.sobchuk.forum.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/")
public class ForumController {


    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ThemeDAO themeDAO;

    @Autowired
    private UserValidator userValidator;


    @GetMapping(value = {"/","/home"})
    public String home(Model model){
        String user = getPrincipal();
        model.addAttribute("user",user);
        model.addAttribute("themes", themeDAO.findAll());
        return "index";
    }

    @GetMapping(value = "/login")
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error){
        ModelAndView model = new ModelAndView();
        if (error != null){
            model.addObject(error, "invalid user name or password!");
        }
        model.setViewName("login");
        return model;
    }

    @GetMapping(value = "/createUser")
    public String registration(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping(value = "/createUser")
    public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result){
        userValidator.validate(user, result);
        if(result.hasErrors()){
            return "register";
        }
        User newUser = new User(user.getName(), user.getEmail(), user.getPassword());
        userDAO.save(newUser);
        return "redirect:/";
    }

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "accessDeniedPage";
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
