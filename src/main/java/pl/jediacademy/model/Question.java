package pl.jediacademy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String goodanswer;
    private String img;

}
