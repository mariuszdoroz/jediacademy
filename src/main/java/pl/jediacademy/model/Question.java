package pl.jediacademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String quest;
    private String answer;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Statistic> statistics;

    public Question(String quest, String answer, Quiz quiz) {
        this.quest = quest;
        this.answer = answer;
        this.quiz = quiz;
    }

    public Question(String quest, String answer) {
        this.quest = quest;
        this.answer = answer;
    }



    public Question() {

    }
}
