package pl.jediacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jediacademy.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
