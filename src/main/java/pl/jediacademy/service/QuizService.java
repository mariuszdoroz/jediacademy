package pl.jediacademy.service;

import org.springframework.stereotype.Service;
import pl.jediacademy.model.Question;
import pl.jediacademy.model.Quiz;
import pl.jediacademy.model.Subject;
import pl.jediacademy.repository.QuestionRepository;
import pl.jediacademy.repository.QuizRepository;
import pl.jediacademy.repository.SubjectRepository;
import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.util.*;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final SubjectRepository subjectRepository;
    private final QuestionRepository questionRepository;
    private final ProgressService progressService;
    private final UserService userService;

    public QuizService(QuizRepository quizRepository, SubjectRepository subjectRepository, QuestionRepository questionRepository, ProgressService progressService, UserService userService) {
        this.quizRepository = quizRepository;
        this.subjectRepository = subjectRepository;
        this.questionRepository = questionRepository;
        this.progressService = progressService;
        this.userService = userService;
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

//    public Map<Quiz, String> mapAllEffe(Principal principal) {
//
//        Map<Quiz, String> quizMapEffe = new TreeMap<>();
//        List<Quiz> quizList = quizRepository.findAll();
//        for (int i = 0; i < quizList.size(); i++) {
//            quizMapEffe.put(quizList.get(i), progressService.quizEffectivenessByUser(userService.findByUsername(principal.getName()).getId(), quizList.get(i).getId()));
//        }
//        return quizMapEffe;
//    }


}
