package pl.jediacademy.service;

import org.springframework.stereotype.Service;
import pl.jediacademy.model.Question;
import pl.jediacademy.model.Quiz;
import pl.jediacademy.model.Subject;
import pl.jediacademy.repository.QuestionRepository;
import pl.jediacademy.repository.QuizRepository;
import pl.jediacademy.repository.SubjectRepository;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final SubjectRepository subjectRepository;
    private final QuestionRepository questionRepository;

    public QuizService(QuizRepository quizRepository, SubjectRepository subjectRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.subjectRepository = subjectRepository;
        this.questionRepository = questionRepository;
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

    public List<Subject> subjectList() {
        return subjectRepository.findAll();
    }

    public List<Question> questionListByQuizId(Long quizid){
        List<Question> questionList = new ArrayList<>();
        questionList = questionRepository.findAllByQuiz_Id(quizid);
        return questionList;
    }

}
