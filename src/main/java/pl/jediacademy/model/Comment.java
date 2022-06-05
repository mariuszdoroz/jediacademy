package pl.jediacademy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public Comment(String content, Date date, User user, Quiz quiz) {
        this.content = content;
        this.date = date;
        this.user = user;
        this.quiz = quiz;
    }

    public Comment() {

    }
}
