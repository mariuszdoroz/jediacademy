package pl.jediacademy.service;

import org.springframework.stereotype.Service;
import pl.jediacademy.model.Comment;
import pl.jediacademy.repository.CommentRepository;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;

    public CommentService(CommentRepository commentRepository, UserService userService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
    }


    public void save(Comment comment) {
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


}
