package pl.jediacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jediacademy.repository.QuestionRepository;
import pl.jediacademy.repository.QuizRepository;

@Controller
@RequestMapping("/dashboard")
public class QuizController {

    private QuestionRepository questionRepository;
    private QuizRepository quizRepository;


    public QuizController(QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

    @GetMapping("/test/{quizid}/{questionid}")
    public String learn(Model model, @PathVariable Long quizid, @PathVariable Long questionid) {
        Long listSize = questionRepository.countQuestionsByQuiz(quizRepository.getById(quizid));
        if(questionid == listSize+1) {
            return "success";
        }
        model.addAttribute("question", questionRepository.getById(questionid));
        model.addAttribute("questionid", questionid+1);
        return "test";
    }
}
