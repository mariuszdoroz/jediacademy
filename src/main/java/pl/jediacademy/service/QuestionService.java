package pl.jediacademy.service;

import org.springframework.stereotype.Service;
import pl.jediacademy.model.Question;
import pl.jediacademy.model.Quiz;
import pl.jediacademy.repository.QuestionRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
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

    public void save(Question question) {
        questionRepository.save(question);
    }

    public void update(Question question) {
        questionRepository.save(question);
    }

    public void delete(Long id) {
        questionRepository.deleteById(id);
    }

}
