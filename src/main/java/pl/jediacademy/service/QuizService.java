package pl.jediacademy.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.jediacademy.model.Quiz;
import pl.jediacademy.model.User;
import pl.jediacademy.repository.QuizRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Quiz getById(Long id) {
        return quizRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Quiz> findAll() {
        return  quizRepository.findAll();
    }

    public Long countQuiz() {
        return quizRepository.count();
    }

    public void save(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public void update(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public void delete(Long id) {
        quizRepository.deleteById(id);
    }

}
