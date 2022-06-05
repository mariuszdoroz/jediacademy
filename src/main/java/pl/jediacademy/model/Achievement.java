package pl.jediacademy.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String img;

}
