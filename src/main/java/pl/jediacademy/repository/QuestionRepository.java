package pl.jediacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jediacademy.model.Question;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
