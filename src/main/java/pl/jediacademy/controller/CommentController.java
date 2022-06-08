package pl.jediacademy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jediacademy.model.Comment;
import pl.jediacademy.service.CommentService;
import pl.jediacademy.service.QuizService;
import pl.jediacademy.service.UserService;

import java.security.Principal;
import java.util.Date;

@Controller
@RequestMapping("/dashboard")
public class CommentController {

    private static final Logger logger = LoggerFactory.getLogger((CommentController.class));

    private CommentService commentService;
    private QuizService quizService;
    private UserService userService;

    public CommentController(CommentService commentService, QuizService quizService, UserService userService) {
        this.commentService = commentService;
        this.quizService = quizService;
        this.userService = userService;
    }

    @GetMapping("/comments/{quizid}")
    public String commentList(Model model, @PathVariable Long quizid) {
        model.addAttribute("quizname", quizService.getById(quizid).getQuizname());
        model.addAttribute("comments", commentService.findAllByQuizId(quizid));
        model.addAttribute("comment", new Comment());
        return "comments";
    }

    @PostMapping("/comments/{quizid}")
    public String addQuiz(Comment comment, @PathVariable Long quizid, Principal principal) {
        commentService.save(comment, quizid, principal);
        return "redirect:/dashboard/comments/"+quizid;
    }

}
