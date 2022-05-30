package pl.jediacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jediacademy.model.Achievement;
import pl.jediacademy.model.User;
import pl.jediacademy.repository.AchievementRepository;
import pl.jediacademy.repository.QuestionRepository;
import pl.jediacademy.repository.QuizRepository;
import pl.jediacademy.repository.UserRepository;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class LearnController {

    @GetMapping("/learn")
    public String learn() {
        return "learn";
    }
}
