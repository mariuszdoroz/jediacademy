package pl.jediacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jediacademy.model.Question;
import pl.jediacademy.service.AchievementService;
import pl.jediacademy.service.QuestionService;
import pl.jediacademy.service.QuizService;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/dashboard")
public class LearnController {

    private QuizService quizService;
    private QuestionService questionService;
    private AchievementService achievementService;

    public LearnController(QuizService quizService, QuestionService questionService, AchievementService achievementService) {
        this.quizService = quizService;
        this.questionService = questionService;
        this.achievementService = achievementService;
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
            Long achiveBrowse = 1L;
            if(achievementService.checkachiv(principal, achiveBrowse)) {
                return "report";
            }
            achievementService.addAchivement(principal);
            model.addAttribute("achiv", achievementService.getAchiveBrowse(achiveBrowse));
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
