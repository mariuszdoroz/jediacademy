package pl.jediacademy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.jediacademy.model.Progress;
import pl.jediacademy.model.Quiz;
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
    private final UserService userService;

    public ProgressService(ProgressRepository progressRepository, UserService userService) {
        this.progressRepository = progressRepository;
        this.userService = userService;
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

    public void save(Progress progress) {
        progressRepository.save(progress);
    }

//    public String quizEffectivenessByUser(Long userid, Long quizid) {
//        Long effe = progressRepository.quizEffectivenessByUser(userid, quizid);
//        return String.valueOf(effe);
//    }
}