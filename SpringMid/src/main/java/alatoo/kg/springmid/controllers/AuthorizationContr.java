package alatoo.kg.springmid.controllers;

import alatoo.kg.springmid.moduels.User;
import alatoo.kg.springmid.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Map;

@Controller
public class AuthorizationContr {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/login")
    public String loginPage(@Valid User user) {
        return "/login";
    }
    @GetMapping("/register")
    public String registerPage() {
        List<User> user = (List<User>) userRepo.findAll();
        return "/register";
    }

    @PostMapping("/register")
    public String addUser(@Valid User user, BindingResult result, Map<String, Object> model) {
        if (result.hasErrors()) {
            return "redirect:/register";
        }
        userRepo.save(user);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logoutPage() {
        return "/logout";
    }
}
