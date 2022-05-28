package pl.jediacademy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String quizname;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public Quiz(String quizname, Subject subject) {
        this.quizname = quizname;
        this.subject = subject;
    }

    public Quiz() {
    }
}
