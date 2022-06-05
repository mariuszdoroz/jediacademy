package pl.jediacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jediacademy.model.Question;
import pl.jediacademy.model.Quiz;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {

    List<Question> findAllByQuiz_Id(Long quizid);
    Long countQuestionsByQuiz(Quiz quiz);
}
