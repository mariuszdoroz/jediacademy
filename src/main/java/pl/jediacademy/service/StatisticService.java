package pl.jediacademy.service;

import org.springframework.stereotype.Service;
import pl.jediacademy.model.Statistic;
import pl.jediacademy.model.User;
import pl.jediacademy.repository.StatisticRepository;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Service
public class StatisticService {

    private final StatisticRepository statisticRepository;

    private QuizService quizService;
    private UserService userService;
    private QuestionService questionService;

    public StatisticService(StatisticRepository statisticRepository, QuizService quizService, UserService userService, QuestionService questionService) {
        this.statisticRepository = statisticRepository;
        this.quizService = quizService;
        this.userService = userService;
        this.questionService = questionService;
    }

    public void save(Long quizid, Long goodid, Long answerid, Principal principal) {
        Statistic qStat = new Statistic();
        qStat.setDate(new Date());
        qStat.setQuiz(quizService.getById(quizid));
        qStat.setUser(userService.findByUsername(principal.getName()));
        qStat.setQuestion(questionService.getById(goodid));
        if(goodid == answerid) {
            qStat.setRightAnswer(true);
        } else {
            qStat.setRightAnswer(false);
        }
        statisticRepository.save(qStat);
    }

    public Long goodanswersCount(int size, Long quizid, Long userid) {
        List<Statistic> lastQuizStat = statisticRepository.lastQuizAnswers(size, quizid, userid);
        Long goodAnswers = 0L;
        for (Statistic q : lastQuizStat) {
            if(q.getRightAnswer()==true) {
                goodAnswers +=1;
            }
        }
        return goodAnswers;
    }
}
