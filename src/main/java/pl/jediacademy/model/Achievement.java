package pl.jediacademy.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mark;
    private String img;

}
