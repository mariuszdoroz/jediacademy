package pl.jediacademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
@ToString
public class Progress {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Long total;
    private Long goodanswers;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public Progress(Long total, Long goodanswers, Date date, User user, Quiz quiz) {
        this.total = total;
        this.goodanswers = goodanswers;
        this.date = date;
        this.user = user;
        this.quiz = quiz;
    }

    public Progress() {

    }
}
