package pl.jediacademy.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.jediacademy.model.Achievement;
import pl.jediacademy.model.User;
import pl.jediacademy.repository.AchievementRepository;
import pl.jediacademy.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.util.List;

@Service
public class AchievementService {
    private final UserService userService;
    private final AchievementRepository achievementRepository;
    private final UserRepository userRepository;

    public AchievementService(UserService userService, AchievementRepository achievementRepository, UserRepository userRepository) {
        this.userService = userService;
        this.achievementRepository = achievementRepository;
        this.userRepository = userRepository;
    }


    public void addAchivement(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        List<Achievement> newList = user.getAchievements();
        if(!newList.contains(achievementRepository.getById(1L))) {
            newList.add(achievementRepository.getById(1L));
            user.setAchievements(newList);
        }
        user.setPassword(user.getPassword());
        userRepository.save(user);
    }

    public Achievement getAchiveBrowse(Long achiveBrowse) {
        return achievementRepository.findById(achiveBrowse).orElseThrow(EntityNotFoundException::new);
    }

    public Boolean checkachiv(Principal principal, Long achiveBrowse) {
        List<Achievement> achievementList = userService.findByUsername(principal.getName()).getAchievements();
        boolean anyNonEmpty = !achievementList.stream()
                .allMatch(achievement -> achievement.getId() == achiveBrowse);
        return anyNonEmpty;
    }
}