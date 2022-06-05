package pl.jediacademy.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Tier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tiername;
    private Long expectedvalue;

    @OneToMany(mappedBy = "tier")
    private List<User> users;

    public Tier(String tiername, Long expectedvalue) {
        this.tiername = tiername;
        this.expectedvalue = expectedvalue;
    }

    public Tier() {

    }
}