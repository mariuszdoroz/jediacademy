package pl.jediacademy.service;

import org.springframework.stereotype.Service;
import pl.jediacademy.model.Question;
import pl.jediacademy.model.QuestionStat;
import pl.jediacademy.model.Statistic;
import pl.jediacademy.model.User;
import pl.jediacademy.repository.StatisticRepository;

import java.security.Principal;
import java.text.NumberFormat;
import java.util.ArrayList;
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

    public Long goodanswersCount(Long size, Long quizid, Long userid) {
        List<Statistic> lastQuizStat = statisticRepository.lastQuizAnswers(size, quizid, userid);
        Long goodAnswers = 0L;
        for (Statistic q : lastQuizStat) {
            if(q.getRightAnswer()==true) {
                goodAnswers +=1;
            }
        }
        return goodAnswers;
    }

    public List<QuestionStat> questionAnswers(Long quizid, String username) {
        Long userid = userService.findByUsername(username).getId();
        List<QuestionStat> questionStatList= new ArrayList<>();
        List<Question> questionList = quizService.questionListByQuizId(quizid);
        for (int i = 0; i < questionList.size(); i++) {
            List<Statistic> lastQuizStat = statisticRepository.questionAnswers(quizid, userid, questionList.get(i).getId());
            Double effe = 0.00;
            Double goodAnswers = 0.00;
            for (Statistic q : lastQuizStat) {
                if(q.getRightAnswer()==true) {
                    goodAnswers +=100.00;
                }
            }
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(0);
            effe = goodAnswers/lastQuizStat.size();
            questionStatList.add(new QuestionStat(questionList.get(i), nf.format(effe)));
        }
        return questionStatList;
    }

}
