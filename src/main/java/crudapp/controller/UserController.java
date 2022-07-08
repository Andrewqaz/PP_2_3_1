package crudapp.controller;

import crudapp.model.User;
import crudapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String users(Model model) {
        List<User> allUsers = service.getAllUsers();
        model.addAttribute("users", allUsers);

        return "users";
    }

    @GetMapping("adduser")
    public String addUserForm(Model model) {
        model.addAttribute("user", new User());
        return "adduser";
    }

    @PostMapping("adduser")
    public String addUser(@ModelAttribute("user") User user) {
        service.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") int userId) {
        service.deleteUserById(userId);

        return "redirect:/";
    }

    @GetMapping("update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        User user = service.getUserById(id);
        model.addAttribute("user", user);
        return "update";
    }

    @PatchMapping("update/{id}")
    public String updateUser(User user, @PathVariable("id") int id) {
        service.updateUser(user);
        return "redirect:/";
    }
}
