package pl.jediacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jediacademy.model.User;
import pl.jediacademy.service.ProgressService;
import pl.jediacademy.service.QuestionService;
import pl.jediacademy.service.QuizService;
import pl.jediacademy.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequestMapping("/dashboard")
public class UserController {

    private UserService userService;
    private QuizService quizService;
    private QuestionService questionService;
    private ProgressService progressService;

    public UserController(UserService userService, QuizService quizService, QuestionService questionService, ProgressService progressService) {
        this.userService = userService;
        this.quizService = quizService;
        this.questionService = questionService;
        this.progressService = progressService;
    }

    @GetMapping()
    public String dashboard(HttpSession httpSession, HttpServletRequest httpServletRequest, Principal principal){
        httpSession.setAttribute("quizcount", quizService.countQuiz());
        httpSession.setAttribute("questioncount", questionService.countQuestion());
        httpSession.setAttribute("effectiveness", progressService.usereffectiveness(principal.getName()));
        return "dashboard";
    }

    @GetMapping("/user/details")
    public String details(Model model, Principal principal){
        model.addAttribute("user", userService.findByUsername(principal.getName()));
        return "userdetails";
    }

    @GetMapping("/user/edit")
    public String userEdit(Model model, Principal principal){
        model.addAttribute("user", userService.editUser(principal.getName()));
        return "useredit";
    }

    @PostMapping("/user/edit")
    public String registerForm(User user) {
        userService.update(user);
        return "success";
    }
}
