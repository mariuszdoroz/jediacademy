package pl.jediacademy.service;

import org.springframework.stereotype.Service;
import pl.jediacademy.model.*;
import pl.jediacademy.repository.*;
import java.util.Arrays;
import java.util.Date;

@Service
public class DataService {


    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private TierRepository tierRepository;
    private SubjectRepository subjectRepository;
    private QuestionRepository questionRepository;
    private QuizRepository quizRepository;
    private AchievementRepository achievementRepository;
    private ProgressRepository progressRepository;
    private CommentRepository commentRepository;
    private StatisticRepository statisticRepository;
    private NotificationRepository notificationRepository;


    public DataService(UserRepository userRepository, RoleRepository roleRepository, TierRepository tierRepository, SubjectRepository subjectRepository, QuestionRepository questionRepository, QuizRepository quizRepository, AchievementRepository achievementRepository, ProgressRepository progressRepository, CommentRepository commentRepository, StatisticRepository statisticRepository, NotificationRepository notificationRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.tierRepository = tierRepository;
        this.subjectRepository = subjectRepository;
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
        this.achievementRepository = achievementRepository;
        this.progressRepository = progressRepository;
        this.commentRepository = commentRepository;
        this.statisticRepository = statisticRepository;
        this.notificationRepository = notificationRepository;
    }

    public void loadData(){
        //role: user
        Role role1 = new Role();
        role1.setName("USER");
        roleRepository.save(role1);
        //role: user
        Role role2 = new Role();
        role2.setName("ADMIN");
        roleRepository.save(role2);
        //Achivment
        Achievement achievement1 = new Achievement();
        achievement1.setName("Moc siln?? w tobie czuj??");
        achievement1.setImg("https://cdn.akamai.steamstatic.com/steamcommunity/public/images/apps/438640/b18058fbd486fa44ca3a6a5bc46b12daa2967fd8.jpg");
        achievementRepository.save(achievement1);
        Achievement achievement2 = new Achievement();
        achievement2.setName("Chewie, jeste??my w domu");
        achievement2.setImg("https://cdn.akamai.steamstatic.com/steamcommunity/public/images/apps/438640/4f58771bd5f6c540e7ca281d5a945022dfb26841.jpg");
        achievementRepository.save(achievement2);
        //Tier
        tierRepository.saveAll(Arrays.asList(new Tier("JEDI",100L), new Tier("RANGER", 75L), new Tier("PADAWAN", 50L)));
        //Subject
        subjectRepository.saveAll(Arrays.asList(new Subject("Geography"), new Subject("English")));
        //Quiz
        quizRepository.save(new Quiz("Stolice Pa??stw!", subjectRepository.findByName("Geography")));
        quizRepository.save(new Quiz("Dni tygodnia!", subjectRepository.findByName("English")));
        quizRepository.save(new Quiz("Miesi??ce!", subjectRepository.findByName("English")));
        quizRepository.save(new Quiz("Rodzina!", subjectRepository.findByName("English")));
        //Questions
        Quiz quiz1 = quizRepository.findById(1L).get();
        questionRepository.saveAll(Arrays.asList(
                new Question("Albania", "Tirana", quiz1),
                new Question("Andora", "Andorra La Vella", quiz1),
                new Question("Austria", "Wiede??", quiz1),
                new Question("Belgia", "Bruksela", quiz1),
                new Question("Bia??oru??", "Mi??sk", quiz1),
                new Question("Bo??nia i Hercegowina", "Sarajewo", quiz1),
                new Question("Bu??garia", "Sofia", quiz1),
                new Question("Chorwacja", "Zagrzeb", quiz1),
                new Question("Czarnog??ra", "Podgorica", quiz1),
                new Question("Czechy", "Praga", quiz1),
                new Question("Dania", "Kopenhaga", quiz1),
                new Question("Estonia", "Tallinn", quiz1),
                new Question("Francja", "Pary??", quiz1),
                new Question("Grecja", "Ateny", quiz1),
                new Question("Hiszpania", "Madryt", quiz1),
                new Question("Holandia", "Amsterdam", quiz1),
                new Question("Irlandia", "Dublin", quiz1),
                new Question("Islandia", "Reykjav??k", quiz1),
                new Question("Kosowo", "Prisztina", quiz1),
                new Question("Liechtenstein", "Vaduz", quiz1),
                new Question("Litwa", "Wilno" , quiz1),
                new Question("Luksemburg", "Luksemburg" , quiz1),
                new Question("??otwa", "Ryga" , quiz1),
                new Question("Macedonia", "Skopje" , quiz1),
                new Question("Malta", "Valletta" , quiz1),
                new Question("Mo??dawia", "Kiszyni??w" , quiz1),
                new Question("Monako", "Monako" , quiz1),
                new Question("Niemcy", "Berlin" , quiz1),
                new Question("Norwegia", "Oslo" , quiz1),
                new Question("Polska", "Warszawa" , quiz1),
                new Question("Portugalia", "Lizbona" , quiz1),
                new Question("Rosja", "Moskwa" , quiz1),
                new Question("Rumunia", "Bukareszt" , quiz1),
                new Question("San Marino", "San Marino" , quiz1),
                new Question("Serbia", "Belgrad" , quiz1),
                new Question("S??owacja", "Bratys??awa" , quiz1),
                new Question("S??owenia", "Lublana" , quiz1),
                new Question("Szwajcaria", "Berno" , quiz1),
                new Question("Szwecja", "Sztokholm" , quiz1),
                new Question("Turcja", "Ankara" , quiz1),
                new Question("Ukraina", "Kij??w" , quiz1),
                new Question("Watykan", "Watykan" , quiz1),
                new Question("W??gry", "Budapeszt" , quiz1),
                new Question("Wielka Brytania", "Londyn" , quiz1),
                new Question("W??ochy", "Rzym", quiz1)
        ));
        Quiz quiz2 = quizRepository.findById(2L).get();
        questionRepository.saveAll(Arrays.asList(
                new Question("Poniedzia??ek", "Monday", quiz2),
                new Question("Wtorek", "Tuesday", quiz2),
                new Question("??roda", "Wednesday", quiz2),
                new Question("Czwartek", "Thursday", quiz2),
                new Question("Pi??tek", "Friday", quiz2),
                new Question("Sobota", "Saturday", quiz2),
                new Question("Niedziela", "Sunday", quiz2)
        ));
        Quiz quiz3 = quizRepository.findById(3L).get();
        questionRepository.saveAll(Arrays.asList(
                new Question("Stycze??", "Januray", quiz3),
                new Question("Luty", "February", quiz3),
                new Question("Marzec", "March ", quiz3),
                new Question("Kwiecie??", "April", quiz3),
                new Question("Maj", "May", quiz3),
                new Question("Czerwiec", "June", quiz3),
                new Question("Lipiec", "July", quiz3),
                new Question("Sierpie??", "August", quiz3),
                new Question("Wrzesie??", "September", quiz3),
                new Question("Pa??dziernik", "October", quiz3),
                new Question("Listopad", "November", quiz3),
                new Question("Grudzie??", "December", quiz3)
        ));
        Quiz quiz4 = quizRepository.findById(4L).get();
        questionRepository.saveAll(Arrays.asList(
                new Question("Mama", "Mum", quiz4),
                new Question("Tata", "Dad", quiz4),
                new Question("Brat", "Brother", quiz4),
                new Question("Siostra", "Sister", quiz4),
                new Question("Ciocia", "Aunt", quiz4),
                new Question("Wujek", "Uncle", quiz4),
                new Question("Babcia", "Grandma", quiz4),
                new Question("Dziadek", "Grapma", quiz4)
        ));
        //username: user
        //pass: 12345
        User user = new User();
        user.setUsername("user");
        user.setPassword("$2a$12$hlg1KLbR/C9jwpLFsZL.nOkpAk0FyAS08vDEluWF.j8tLBrORpk0e");
        user.setEmail("user@example.com");
        user.setRole(roleRepository.findRoleByName("USER"));
        user.setTier(tierRepository.findTierByTiername("PADAWAN"));
        user.setAchievements(achievementRepository.findAll());
        userRepository.save(user);
        //username: admin
        //pass: 12345
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("$2a$12$hlg1KLbR/C9jwpLFsZL.nOkpAk0FyAS08vDEluWF.j8tLBrORpk0e");
        admin.setEmail("admin@example.com");
        admin.setRole(roleRepository.findRoleByName("ADMIN"));
        admin.setTier(tierRepository.findTierByTiername("PADAWAN"));
        userRepository.save(admin);
        //progress
        progressRepository.save(new Progress(7L,5L,new Date(), user,quiz2));
        commentRepository.saveAll(Arrays.asList(new Comment(1L, "Very good", new Date(), user, quiz1), new Comment(2L, "Very very good", new Date(), user, quiz1)));
        statisticRepository.saveAll(Arrays.asList(
                new Statistic(true, new Date(), user, questionRepository.getById(47L), quiz1),
                new Statistic(true, new Date(), user, questionRepository.getById(47L), quiz1),
                new Statistic(true, new Date(), user, questionRepository.getById(47L), quiz1),
                new Statistic(true, new Date(), user, questionRepository.getById(47L), quiz1),
                new Statistic(true, new Date(), user, questionRepository.getById(47L), quiz1),
                new Statistic(true, new Date(), user, questionRepository.getById(47L), quiz1),
                new Statistic(true, new Date(), user, questionRepository.getById(47L), quiz1),
                new Statistic(true, new Date(), user, questionRepository.getById(47L), quiz1),
                new Statistic(true, new Date(), user, questionRepository.getById(47L), quiz1),
                new Statistic(true, new Date(), user, questionRepository.getById(47L), quiz1),
                new Statistic(true, new Date(), user, questionRepository.getById(47L), quiz1)));
        notificationRepository.saveAll(Arrays.asList(
                new Notification("Patience you must have my young Padawan.", "BAD"),
                new Notification("Feel the force!", "BAD"),
                new Notification("Control, control, you must learn control!", "BAD"),
                new Notification("Powerful you have become, the dark side I sense in you.", "GOOD"),
                new Notification("Truly wonderful the mind of a child is.", "GOOD"),
                new Notification("Train yourself to let go of everything you fear to lose.", "GOOD")
                ));
    }
}
