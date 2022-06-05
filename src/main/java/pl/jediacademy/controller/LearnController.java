package pl.jediacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jediacademy.model.Question;
import pl.jediacademy.service.QuestionService;
import pl.jediacademy.service.QuizService;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/dashboard")
public class LearnController {

    private QuizService quizService;
    private QuestionService questionService;

    public LearnController(QuizService quizService, QuestionService questionService) {
        this.quizService = quizService;
        this.questionService = questionService;
    }

    @GetMapping("/learn")
    public String learn(Model model) {
        model.addAttribute("quizList", quizService.findAll());
        return "learn";
    }
//browse
    @GetMapping("/learn/{quizid}/browse/{questionid}")
    public String browse(Model model, @PathVariable Long quizid, @PathVariable Long questionid, Principal principal) {
        List<Question> questionsList = questionService.findByQuiz(quizid);
        model.addAttribute("quiz", quizService.getById(quizid));
        if(questionid == questionsList.size()) {
//            questionService.addAchivement(principal);
            return "report";
        }
        model.addAttribute("question", questionsList.get(Math.toIntExact(questionid)));
        model.addAttribute("questionid", questionid+1);
        return "learnbrowse";
    }
//know

//write

//quiz

//jedi

}
