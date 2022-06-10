package pl.jediacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jediacademy.model.User;
import pl.jediacademy.repository.RoleRepository;
import pl.jediacademy.service.DataService;
import pl.jediacademy.service.UserService;

@Controller
@RequestMapping
public class HomeController {

    private UserService userService;
    private RoleRepository roleRepository;
    private DataService dataService;

    public HomeController(UserService userService, RoleRepository roleRepository, DataService dataService) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.dataService = dataService;
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
        if(roleRepository.findAll().size() == 0){
            dataService.loadData();
        }
        return "login";
    }
}
