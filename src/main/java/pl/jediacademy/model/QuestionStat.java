package pl.jediacademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionStat {

    private Question question;
    private String effe;

    public QuestionStat() {
    }
}
