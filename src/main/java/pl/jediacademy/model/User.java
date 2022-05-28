package pl.jediacademy.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "tier_id")
    private Tier tier;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Achievement> achievements;
}
