package pl.jediacademy.service;

import org.springframework.stereotype.Service;
import pl.jediacademy.model.Comment;
import pl.jediacademy.repository.CommentRepository;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;
    private final QuizService quizService;

    public CommentService(CommentRepository commentRepository, UserService userService, QuizService quizService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.quizService = quizService;
    }


    public void save(Comment comment, Long quizid, Principal principal) {
        Comment newComment = comment;
        newComment.setQuiz(quizService.getById(quizid));
        newComment.setDate(new Date());
        newComment.setUser(userService.findByUsername(principal.getName()));
        commentRepository.save(comment);
    }

    public void update(Comment comment) {
    }

    public void delete(Comment comment) {

    }

    public String countAllComments(String username) {
        Long userid = userService.findByUsername(username).getId();
        List<Comment> commentList = commentRepository.findAllByUserId(userid);
        return String.valueOf(commentList.size());
    }

    public List<Comment> findAllByQuizId(Long quizid) {
        return commentRepository.findcommentsquizid(quizid);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }


}
