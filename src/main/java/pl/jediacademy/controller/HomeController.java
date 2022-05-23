package pl.jediacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jediacademy.model.User;
import pl.jediacademy.repository.UserRepository;

import java.security.Principal;


@Controller
@RequestMapping
public class HomeController {

    private UserRepository userRepository;

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home(Model model, Principal principal){
        String name = principal.getName();
        model.addAttribute("user", userRepository.findByUsername(name));
        return "welcome";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
