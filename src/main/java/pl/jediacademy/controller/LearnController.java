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

    private QuizRepository quizRepository;
    private QuestionRepository questionRepository;
    private UserRepository userRepository;
    private AchievementRepository achievementRepository;

    public LearnController(QuizRepository quizRepository, QuestionRepository questionRepository, UserRepository userRepository, AchievementRepository achievementRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.achievementRepository = achievementRepository;
    }

    @GetMapping("/learn/{quizid}/{questionid}")
    public String learn(Model model, @PathVariable Long quizid, @PathVariable Long questionid, Principal principal) {
        Long listSize = questionRepository.countQuestionsByQuiz(quizRepository.getById(quizid));
        if(questionid == listSize+1) {
            User user = userRepository.findByUsername(principal.getName());
            List<Achievement> newList = user.getAchievements();
            if(!newList.contains(achievementRepository.getById(1L))) {
                newList.add(achievementRepository.getById(1L));
                user.setAchievements(newList);
                userRepository.save(user);
            }
            return "success";
        }
        model.addAttribute("question", questionRepository.getById(questionid));
        model.addAttribute("questionid", questionid+1);
        return "test";
    }
}
