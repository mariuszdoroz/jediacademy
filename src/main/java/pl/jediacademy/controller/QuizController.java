package pl.jediacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jediacademy.model.Question;
import pl.jediacademy.repository.QuestionRepository;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class QuizController {

    private QuestionRepository questionRepository;

    public QuizController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/test")
    public String registerForm(Model model, @RequestParam Long quizid) {
        List<Question> questionList = questionRepository.findAllByQuiz_Id(quizid);
        model.addAttribute("questionList", questionList);
        return "test";
    }
}
