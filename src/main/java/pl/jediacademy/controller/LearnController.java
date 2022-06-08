package pl.jediacademy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jediacademy.model.Question;
import pl.jediacademy.service.*;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/dashboard")
public class LearnController {

    private static final Logger logger = LoggerFactory.getLogger((LearnController.class));

    private QuizService quizService;
    private QuestionService questionService;
    private AchievementService achievementService;
    private StatisticService statisticService;
    private ProgressService progressService;

    public LearnController(QuizService quizService, QuestionService questionService, AchievementService achievementService, StatisticService statisticService, ProgressService progressService) {
        this.quizService = quizService;
        this.questionService = questionService;
        this.achievementService = achievementService;
        this.statisticService = statisticService;
        this.progressService = progressService;
    }

    @GetMapping("/learn")
    public String learn(Model model, Principal principal) {
//        model.addAttribute("quizList", quizService.mapAllEffe(principal));
        model.addAttribute("quizList", quizService.findAll());
        return "learn";
    }

    //browse
    @GetMapping("/learn/{quizid}/browse/{questionid}")
    public String browse(Model model, @PathVariable Long quizid, @PathVariable Long questionid, Principal principal) {
        List<Question> questionsList = questionService.findByQuiz(quizid);
        model.addAttribute("quiz", quizService.getById(quizid));
        if (questionid == questionsList.size()) {
            Long achiveBrowse = 1L;
            if (achievementService.checkachiv(principal, achiveBrowse)) {
                return "report";
            }
            achievementService.addAchivement(principal);
            model.addAttribute("achiv", achievementService.getAchiveBrowse(achiveBrowse));
            return "report";
        }
        model.addAttribute("question", questionsList.get(Math.toIntExact(questionid)));
        model.addAttribute("questionid", questionid + 1);
        return "learnbrowse";
    }
//know

//write

    //quiz
    @GetMapping("/learn/{quizid}/quiz/{questionid}")
    public String quizGet(Model model, @PathVariable Long quizid, @PathVariable Long questionid, Principal principal) {
        List<Question> questionsList = questionService.findByQuiz(quizid);
        model.addAttribute("quiz", quizService.getById(quizid));
        if (questionid == questionsList.size()) {
            Long achiveBrowse = 2L;
            progressService.save(questionsList.size(), quizid, principal);
            if (achievementService.checkachiv(principal, achiveBrowse)) {
                return "report";
            }
            achievementService.addAchivement(principal);
            model.addAttribute("achiv", achievementService.getAchiveBrowse(achiveBrowse));
            return "report";
        }
        Question question = questionsList.get(Math.toIntExact(questionid));
        List<Question> questionListRandomFour = questionsList;
        questionListRandomFour.remove(question);
        Collections.shuffle(questionListRandomFour);
        questionListRandomFour = questionsList
                .stream().limit(3)
                .collect(Collectors.toList());
        questionListRandomFour.add(question);
        Collections.shuffle(questionListRandomFour);
        model.addAttribute("answer", questionListRandomFour);
        model.addAttribute("question", question);
        model.addAttribute("questionid", questionid + 1);
        return "learnquiz";
    }

    @PostMapping("/learn/{quizid}/quiz/{questionid}")
    public String quizPost(Model model, @PathVariable Long quizid, @PathVariable Long questionid, @RequestParam Long answerid,@RequestParam Long goodid, Principal principal) {
        statisticService.save(quizid, goodid, answerid, principal);
        return "redirect:/dashboard/learn/"+quizid+"/quiz/"+(questionid+1);
    }

    //jedi
    @GetMapping("/learn/{quizid}/jedi/{questionid}")
    public String jediGet(Model model, @PathVariable Long quizid, @PathVariable Long questionid, Principal principal) {
        List<Question> questionsList = questionService.findByQuiz(quizid);
        List<Question> questionListRandomFour = questionsList;
        model.addAttribute("quiz", quizService.getById(quizid));
        logger.info(String.valueOf(questionsList.size()));
        for (int i = 0; i < questionsList.size(); i++) { //+1?
            logger.info(String.valueOf(questionService.questionEffe(principal, questionsList.get(i).getId())));
            if(questionService.questionEffe(principal, questionsList.get(i).getId()) > 75) {
                questionsList.remove(i);
            }
        }
        if (questionid == questionsList.size()) {
            Long achiveBrowse = 2L;
            if (achievementService.checkachiv(principal, achiveBrowse)) {
                return "report";
            }
            achievementService.addAchivement(principal);
            model.addAttribute("achiv", achievementService.getAchiveBrowse(achiveBrowse));
            return "report";
        }
        Question question = questionsList.get(Math.toIntExact(questionid));
        questionListRandomFour.remove(question);
        Collections.shuffle(questionListRandomFour);
        questionListRandomFour = questionsList
                .stream().limit(3)
                .collect(Collectors.toList());
        questionListRandomFour.add(question);
        Collections.shuffle(questionListRandomFour);
        model.addAttribute("answer", questionListRandomFour);
        model.addAttribute("question", question);
        model.addAttribute("questionid", questionid + 1);
        return "learnjedi";
    }
}
