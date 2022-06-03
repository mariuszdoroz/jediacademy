package pl.jediacademy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String question;
    private String answer;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    public Question(String question, String answer, Quiz quiz) {
        this.question = question;
        this.answer = answer;
        this.quiz = quiz;

    }

    public Question() {

    }
}
