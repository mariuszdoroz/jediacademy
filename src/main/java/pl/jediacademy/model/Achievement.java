package pl.jediacademy.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String mark;
    private String img;
}
