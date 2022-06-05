package pl.jediacademy.service;

import org.springframework.stereotype.Service;
import pl.jediacademy.model.Achievement;
import pl.jediacademy.model.Question;
import pl.jediacademy.model.Quiz;
import pl.jediacademy.model.User;
import pl.jediacademy.repository.AchievementRepository;
import pl.jediacademy.repository.QuestionRepository;
import pl.jediacademy.repository.QuizRepository;
import pl.jediacademy.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;
    private final UserRepository userRepository;
    private final AchievementRepository achievementRepository;

    public QuestionService(QuestionRepository questionRepository, QuizRepository quizRepository, UserRepository userRepository, AchievementRepository achievementRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
        this.userRepository = userRepository;
        this.achievementRepository = achievementRepository;
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

    public Long countQuestionsByQuiz(Quiz quiz) {
        return questionRepository.countQuestionsByQuiz(quiz);
    }

    public void addAchivement(Principal principal) {
            User user = userRepository.findByUsername(principal.getName());
            List<Achievement> newList = user.getAchievements();
            if(!newList.contains(achievementRepository.getById(1L))) {
                newList.add(achievementRepository.getById(1L));
                user.setAchievements(newList);
                userRepository.save(user);
            }
    }

    public List<Question> findByQuiz(Long quizid) {
        return questionRepository.findAllByQuiz_Id(quizid);
    }
}
