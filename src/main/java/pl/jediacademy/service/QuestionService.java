package pl.jediacademy.service;

import org.springframework.stereotype.Service;
import pl.jediacademy.model.*;
import pl.jediacademy.repository.*;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.text.NumberFormat;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;
    private final UserRepository userRepository;
    private final AchievementRepository achievementRepository;
    private final StatisticRepository statisticRepository;
    private final UserService userService;

    public QuestionService(QuestionRepository questionRepository, QuizRepository quizRepository, UserRepository userRepository, AchievementRepository achievementRepository, StatisticRepository statisticRepository, UserService userService) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
        this.userRepository = userRepository;
        this.achievementRepository = achievementRepository;
        this.statisticRepository = statisticRepository;
        this.userService = userService;
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

    public List<Question> findByQuiz(Long quizid) {
        return questionRepository.findAllByQuiz_Id(quizid);
    }

    public Double questionEffe(Principal principal, Long questionid) {
        Long userid = userService.findByUsername(principal.getName()).getId();
        List<Statistic> statisticList= statisticRepository.findAllByQuestionIdUserId(userid, questionid);
        Double effe = 0.00;
        int score = 0;
        if(statisticList.size() >0) {
            if(statisticList.size() > 0) { //piwo za zrobienie tego jako stream
                for (int i = 0; i < statisticList.size(); i++) { //+1?
                    if (statisticList.get(i).getRightAnswer()) {
                        score += 10;
                    }
                }
            }
            effe = Double.valueOf(score / statisticList.size());
        } else {
            effe = 0.5;
        }
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        return Double.valueOf(nf.format(effe*10));
    }
}
