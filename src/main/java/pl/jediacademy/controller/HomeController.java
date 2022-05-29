package pl.jediacademy.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jediacademy.model.User;
import pl.jediacademy.repository.RoleRepository;
import pl.jediacademy.repository.TierRepository;
import pl.jediacademy.repository.UserRepository;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class HomeController {

    private UserRepository userRepository;
    private TierRepository tierRepository;
    private RoleRepository roleRepository;

    public HomeController(UserRepository userRepository, TierRepository tierRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.tierRepository = tierRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/dashboard";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerForm(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setTier(tierRepository.findTierByTiername("PADAWAN"));
        user.setRole(roleRepository.findRoleByName("USER"));
        userRepository.save(user);
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
