package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/")
public class AllUsersController {
    @Autowired
    UserService userService;

    @RequestMapping(value ="all", method = RequestMethod.GET)
    public String loginJsp(Model model) {
        model.addAttribute("messages", userService.listUsers());
        return "users";
    }

    @RequestMapping(value = "add", method = RequestMethod.PUT)
    public void addUser(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("email") String email, Model model){
        userService.add(new User(firstName, lastName, email));
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void updateUser(@RequestParam("id") Long id ,
                           @RequestParam("newFirstName") String newFirstName,
                           @RequestParam("newLastName") String newLastName,
                           @RequestParam("newEmail") String newEmail, Model model){
        User user = new User(id, newFirstName, newLastName, newEmail);
        userService.updateUser(user);
    }
}
