package pl.jediacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jediacademy.service.ProgressService;
import pl.jediacademy.service.QuizService;
import pl.jediacademy.service.StatisticService;

import java.security.Principal;

@Controller
@RequestMapping("/dashboard")
public class StatisticController {

    private ProgressService progressService;
    private StatisticService statisticService;
    private QuizService quizService;

    public StatisticController(ProgressService progressService, StatisticService statisticService, QuizService quizService) {
        this.progressService = progressService;
        this.statisticService = statisticService;
        this.quizService = quizService;
    }

    @GetMapping("/learn/{quizid}/statistic")
    public String learn(Model model, @PathVariable Long quizid, Principal principal) {
        model.addAttribute("quizeffectiveness", progressService.userquizeffectiveness(principal.getName(), quizid));
        model.addAttribute("questionseffectiveness", statisticService.questionAnswers(quizid,principal.getName()));
        return "statistic";
    }
}
