package pl.jediacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jediacademy.repository.UserRepository;

@Controller
@RequestMapping("/dashboard")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public String dashboard(){
        return "dashboard";
    }
}
