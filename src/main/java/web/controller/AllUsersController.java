package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/")
public class AllUsersController {
    @Autowired
    UserService userService;

    @GetMapping(value = "all")
    public String loginJsp(Model model) {
        model.addAttribute("messages", userService.listUsers());
        return "users";
    }

    @GetMapping(value = "getUpdate")
    public String getUpdate(@RequestParam("id") String id,
                            Model model) {
        User user = userService.getUserById(Long.parseLong(id));
        model.addAttribute("user", user);
        return "update";
    }

    @PostMapping(value = "add")
    public String addUser(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("email") String email,
                        @RequestParam("password") String password,
                        @RequestParam("role") String role, HttpServletResponse response) throws IOException {
        List<Role> list = new ArrayList<>();
        list.add(new Role(role.toUpperCase()));
        userService.add(new User(firstName, lastName, email, password, list));
        return "redirect:/admin/all";
    }

    @PostMapping(value = "update")
    public String updateUser(@RequestParam("id") Long id,
                           @RequestParam("newFirstName") String newFirstName,
                           @RequestParam("newLastName") String newLastName,
                           @RequestParam("newEmail") String newEmail,
                           @RequestParam("newPassword") String password, HttpServletResponse response) throws IOException {
        User user = new User(id, newFirstName, newLastName, newEmail, password);
        userService.updateUser(user);
        return "redirect:/admin/all";
    }

    @GetMapping(value = "delete")
    public String deleteUser(@RequestParam("id") String id, HttpServletResponse response) throws IOException {
        User user = userService.getUserById(Long.parseLong(id));
        userService.deleteUser(user);
        return "redirect:/admin/all";
    }

    @PostMapping(value = "updateRole")
    public String updateRole(@RequestParam("selectRole") String role,
                           @RequestParam("id") Long id, HttpServletResponse response) throws IOException {
        userService.updateUserRole(role, id);
        return "redirect:/admin/all";
    }
}
