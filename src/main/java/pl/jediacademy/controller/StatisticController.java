package pl.jediacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jediacademy.model.User;
import pl.jediacademy.service.ProgressService;
import pl.jediacademy.service.QuizService;
import pl.jediacademy.service.StatisticService;
import pl.jediacademy.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/dashboard")
public class StatisticController {

    private ProgressService progressService;
    private StatisticService statisticService;
    private QuizService quizService;
    private UserService userService;

    public StatisticController(ProgressService progressService, StatisticService statisticService, QuizService quizService, UserService userService) {
        this.progressService = progressService;
        this.statisticService = statisticService;
        this.quizService = quizService;
        this.userService = userService;
    }

    @GetMapping("/learn/{quizid}/statistic")
    public String learn(Model model, @PathVariable Long quizid, Principal principal) {
        model.addAttribute("userlist", userService.findAll());
        model.addAttribute("quizeffectiveness", progressService.userquizeffectiveness(principal.getName(), quizid));
        model.addAttribute("questionseffectiveness", statisticService.questionAnswers(quizid,principal.getName()));
        return "statistic";
    }

    @PostMapping("/learn/{quizid}/statistic")
    public String learn(Model model, @PathVariable Long quizid, @RequestParam String userselect) {
        model.addAttribute("userlist", userService.findAll());
        model.addAttribute("quizeffectiveness", progressService.userquizeffectiveness(userselect, quizid));
        model.addAttribute("questionseffectiveness", statisticService.questionAnswers(quizid,userselect));
        return "statistic";
    }
}
