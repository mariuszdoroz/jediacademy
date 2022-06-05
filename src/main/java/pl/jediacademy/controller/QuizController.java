package pl.jediacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jediacademy.model.Question;
import pl.jediacademy.model.Quiz;
import pl.jediacademy.model.Subject;
import pl.jediacademy.service.QuestionService;
import pl.jediacademy.service.QuizService;

import java.util.Collection;

@Controller
@RequestMapping("/dashboard")
public class QuizController {

    public final QuizService quizService;
    public final QuestionService questionService;

    public QuizController(QuizService quizService, QuestionService questionService) {
        this.quizService = quizService;
        this.questionService = questionService;
    }


    @GetMapping("/quiz")
    public String quizList(Model model) {
        model.addAttribute("quizList", quizService.findAll());
        model.addAttribute("quiz", new Quiz());
        return "quiz";
    }

    @ModelAttribute("subjects")
    public Collection<Subject> subjects() {
        return this.quizService.subjectList();
    }

    @PostMapping("/quiz/add")
    public String addQuiz(Quiz quiz) {
        quizService.save(quiz);
        return "redirect:/dashboard/quiz";
    }

    @GetMapping("/quiz/delete/{quizid}")
    public String deleteQuiz(Model model, @PathVariable Long quizid) {
        if (quizService.questionListByQuizId(quizid).size() > 0) {
            model.addAttribute("quizid", quizid);
            return "quizconfirmdelete";
        } else {
            quizService.delete(quizid);
            return "redirect:/dashboard/quiz";
        }
    }

    @GetMapping("/quiz/confirmdel/{quizid}")
    public String confirmQuizDelete(@PathVariable Long quizid) {
        quizService.delete(quizid);
        return "redirect:/dashboard/quiz";
    }

    @GetMapping("/quiz/details/{quizid}")
    public String detailsQuiz(@PathVariable Long quizid, Model model) {
        model.addAttribute("questionList", quizService.questionListByQuizId(quizid));
        model.addAttribute("quiz", quizService.getById(quizid));
        model.addAttribute("question", new Question());
        return "quizdetails";
    }

    @GetMapping("/quiz/{quizid}/question/delete/{questionid}")
    public String detailsQuiz(@PathVariable Long quizid, @PathVariable Long questionid) {
        questionService.delete(questionid);
        return "redirect:/dashboard/quiz/details/"+quizid;
    }

    @PostMapping("/quiz/details/{quizid}")
    public String addQuiz(Question question, @PathVariable Long quizid) {
        questionService.save(quizid, question);
        return "redirect:/dashboard/quiz/details/"+quizid;
    }
}