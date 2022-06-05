package pl.jediacademy.service;

import org.springframework.stereotype.Service;
import pl.jediacademy.model.Question;
import pl.jediacademy.repository.QuestionRepository;
import pl.jediacademy.repository.QuizRepository;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;

    public QuestionService(QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

    public Question getById(Long id) {
        return questionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Question> findAll() {
        return  questionRepository.findAll();
    }

    public Long countQuestion() {
        return questionRepository.count();
    }

    public void save(Long quizid, Question question) {
        question.setQuiz(quizRepository.getById(quizid));
        questionRepository.save(question);
    }

    public void update(Question question) {
        questionRepository.save(question);
    }

    public void delete(Long id) {
        questionRepository.deleteById(id);
    }

}
