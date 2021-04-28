package com.forgottenrelations.forgottenRelationsBlog.controllers;

import com.forgottenrelations.forgottenRelationsBlog.data.UserData;
import com.forgottenrelations.forgottenRelationsBlog.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping()
    public String login(Model model) {
        model.addAttribute("users", UserData.getAll());
        return "user/login";
    }

    @PostMapping()
    public String processLogin(@RequestParam String email, @RequestParam String password, Model model) {
        if(UserData.containsUserByEmail(email)) {
            if(UserData.getUserByEmail(email).getPassword().equals(password)) {
                return "redirect:../";
            }
        }
        model.addAttribute("users", UserData.getAll());
        model.addAttribute("passwordErr", "Invalid email or password");
        return "user/login";
    }

    @GetMapping("create")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @PostMapping("create")
    public  String processCreate(@ModelAttribute User user,
                                 @RequestParam String verifyPassword,
                                 Model model) {
        if(verifyPassword.equals(user.getPassword()) && !UserData.containsUser(user)) {
            UserData.addUser(user);
            return "redirect:..";
        }
        model.addAttribute("user", user);
        return "user/create";
    }

}
