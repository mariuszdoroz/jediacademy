package pl.jediacademy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.jediacademy.model.Progress;
import pl.jediacademy.model.User;
import pl.jediacademy.repository.ProgressRepository;

import java.security.Principal;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProgressService {

    private static final Logger logger = LoggerFactory.getLogger((ProgressService.class));


    private final ProgressRepository progressRepository;
    private final QuizService quizService;
    private final UserService userService;
    private final StatisticService statisticService;

    public ProgressService(ProgressRepository progressRepository, QuizService quizService, UserService userService, StatisticService statisticService) {
        this.progressRepository = progressRepository;
        this.quizService = quizService;
        this.userService = userService;
        this.statisticService = statisticService;
    }

    public String usereffectiveness(String username) {
        Long userid = userService.findByUsername(username).getId();
        logger.info(String.valueOf(userid));
        List<Progress> progress = progressRepository.findAllByUserId(userid);
        Double effe = 0.00;
        if(progress.size() > 0) {
            effe = progress.stream()
                    .mapToDouble(e -> e.getGoodanswers()/Double.valueOf(e.getTotal()))
                    .average().getAsDouble();
        }
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(0);
        return nf.format(effe*100);
    }

    public void save(int size, Long quizid, Principal principal) {
        Progress qProgress = new Progress();
        qProgress.setDate(new Date());
        qProgress.setQuiz(quizService.getById(quizid));
        qProgress.setTotal((long) size);
        User user = userService.findByUsername(principal.getName());
        qProgress.setUser(user);
        qProgress.setGoodanswers(statisticService.goodanswersCount(size, quizid, user.getId()));
        progressRepository.save(qProgress);
    }

//    public String quizEffectivenessByUser(Long userid, Long quizid) {
//        Long effe = progressRepository.quizEffectivenessByUser(userid, quizid);
//        return String.valueOf(effe);
//    }
}