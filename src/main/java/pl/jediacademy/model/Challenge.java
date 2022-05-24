package pl.jediacademy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date startdate;
    private Date enddate;
}
