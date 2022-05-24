package pl.jediacademy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String quizname;
}
