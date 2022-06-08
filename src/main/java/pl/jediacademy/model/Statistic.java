package pl.jediacademy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean rightAnswer;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public Statistic(Boolean rightAnswer, Date date, User user, Question question, Quiz quiz) {
        this.rightAnswer = rightAnswer;
        this.date = date;
        this.user = user;
        this.question = question;
        this.quiz = quiz;
    }

    public Statistic() {

    }
}
