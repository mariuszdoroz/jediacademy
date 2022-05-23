package pl.jediacademy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Statistic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long total;
    private Long goodanswers;
    private Date date;
}
