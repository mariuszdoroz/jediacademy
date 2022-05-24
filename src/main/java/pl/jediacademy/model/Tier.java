package pl.jediacademy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Tier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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