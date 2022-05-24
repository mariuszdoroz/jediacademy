package pl.jediacademy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Progress {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private Long progress;
    private Date date;

}
