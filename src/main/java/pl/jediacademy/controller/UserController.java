package pl.jediacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jediacademy.model.User;
import pl.jediacademy.repository.UserRepository;

import java.security.Principal;

@Controller
@RequestMapping("/dashboard")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public String dashboard(){
        return "dashboard";
    }

    @GetMapping("/user/details")
    public String details(Model model, Principal principal){
        String name = principal.getName();
        model.addAttribute("user", userRepository.findByUsername(name));
        return "userdetails";
    }

    @GetMapping("/user/edit")
    public String userEdit(Model model, Principal principal){
        String name = principal.getName();
        model.addAttribute("user", userRepository.findByUsername(name));
        return "useredit";
    }

    @PostMapping("/user/edit")
    public String registerForm(User user) {
        User updateUser = userRepository.getUserById(user.getId());
        updateUser.setUsername(user.getUsername());
        updateUser.setEmail(user.getEmail());
        if(user.getPassword().equals(userRepository.getUserById(user.getId()).getPassword())) {
            user.setPassword(user.getPassword());
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            updateUser.setPassword(encodedPassword);
        }
        userRepository.save(updateUser);
        return "success";
    }
}
