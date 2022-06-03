package pl.jediacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/dashboard")
public class LearnController {

    @GetMapping("/learn")
    public String learn() {
        return "learn";
    }
}
