package pl.jediacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jediacademy.model.User;
import pl.jediacademy.service.UserService;

@Controller
@RequestMapping
public class HomeController {

    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/")
    public String home() {
        return "redirect:/dashboard";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerForm(User user) {
        userService.save(user);
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
