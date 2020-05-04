package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import web.model.User;
import web.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/")
public class AllUsersController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String loginJsp(Model model) {
        model.addAttribute("messages", userService.listUsers());
        return "users";
    }

    @RequestMapping(value = "getUpdate", method = RequestMethod.GET)
    public String getUpdate(@RequestParam("id") String id,
                            Model model) {
        User user = userService.getUserById(Long.parseLong(id));
        model.addAttribute("user", user);
        return "update";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void addUser(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("email") String email, HttpServletResponse response) throws IOException {
        userService.add(new User(firstName, lastName, email));
        response.sendRedirect("/all");
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public void updateUser(@RequestParam("id") Long id,
                             @RequestParam("newFirstName") String newFirstName,
                             @RequestParam("newLastName") String newLastName,
                             @RequestParam("newEmail") String newEmail, HttpServletResponse response) throws IOException {
        User user = new User(id, newFirstName, newLastName, newEmail);
        userService.updateUser(user);
        response.sendRedirect("/all");
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public void deleteUser(@RequestParam("id") String id, HttpServletResponse response) throws IOException {
        User user = userService.getUserById(Long.parseLong(id));
        userService.deleteUser(user);
        response.sendRedirect("/all");
    }
}
