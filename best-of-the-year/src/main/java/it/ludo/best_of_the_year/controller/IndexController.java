package it.ludo.best_of_the_year.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.ludo.best_of_the_year.model.User;

@Controller
public class IndexController {

    @GetMapping("/")
    public String year(Model model) {
        User user = new User("Ludovica");

        model.addAttribute("user", user);
        return "year";
    }
}
