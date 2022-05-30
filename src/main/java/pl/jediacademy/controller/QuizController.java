package pl.jediacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jediacademy.service.QuizService;

@Controller
@RequestMapping("/dashboard")
public class QuizController {

    public final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }


    @GetMapping("/quiz")
    public String quizList(Model model) {
        model.addAttribute("quizList", quizService.findAll());
        return "quiz";
    }
}