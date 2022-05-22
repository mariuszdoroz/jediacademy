package pl.jediacademy.model;

import lombok.Data;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.List;

@Data
@Entity
@Table
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "role")
    private List<User> users;
}
