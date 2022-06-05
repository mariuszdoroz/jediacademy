package pl.jediacademy.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String message;

    public Notification(String message, String type) {
        this.message = message;
        this.type = type;

    }

    public Notification() {

    }
}
