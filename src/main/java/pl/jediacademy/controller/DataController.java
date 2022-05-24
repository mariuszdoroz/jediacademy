package pl.jediacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jediacademy.model.*;
import pl.jediacademy.repository.*;

import java.util.Arrays;


@Controller
@RequestMapping
public class DataController {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private TierRepository tierRepository;
    private SubjectRepository subjectRepository;
    private QuestionRepository questionRepository;
    private QuizRepository quizRepository;


    public DataController(UserRepository userRepository, RoleRepository roleRepository, TierRepository tierRepository, SubjectRepository subjectRepository, QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.tierRepository = tierRepository;
        this.subjectRepository = subjectRepository;
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }


    @GetMapping("/data")
    public String data(){
        //role: user
        Role role1 = new Role();
        role1.setName("USER");
        roleRepository.save(role1);
        //role: user
        Role role2 = new Role();
        role2.setName("ADMIN");
        roleRepository.save(role2);
        //Tier
        tierRepository.saveAll(Arrays.asList(new Tier("JEDI",100L), new Tier("RANGER", 75L), new Tier("PADAWAN", 50L)));
        //Subject
        subjectRepository.saveAll(Arrays.asList(new Subject("GEOGRAPHY"), new Subject("POLISH")));
        //Quiz
        quizRepository.save(new Quiz("Stolice Państw!", subjectRepository.findByName("GEOGRAPHY")));
        //Questions
        Quiz quiz = quizRepository.findById(1L).get();
        questionRepository.saveAll(Arrays.asList(
                new Question("Albania", "Tirana", quiz),
                new Question("Andora", "Andorra La Vella", quiz),
                new Question("Austria", "Wiedeń", quiz),
                new Question("Belgia", "Bruksela", quiz),
                new Question("Białoruś", "Mińsk", quiz),
                new Question("Bośnia i Hercegowina", "Sarajewo", quiz),
                new Question("Bułgaria", "Sofia", quiz),
                new Question("Chorwacja", "Zagrzeb", quiz),
                new Question("Czarnogóra", "Podgorica", quiz),
                new Question("Czechy", "Praga", quiz),
                new Question("Dania", "Kopenhaga", quiz),
                new Question("Estonia", "Tallinn", quiz),
                new Question("Francja", "Paryż", quiz),
                new Question("Grecja", "Ateny", quiz),
                new Question("Hiszpania", "Madryt", quiz),
                new Question("Holandia", "Amsterdam", quiz),
                new Question("Irlandia", "Dublin", quiz),
                new Question("Islandia", "Reykjavík", quiz),
                new Question("Kosowo", "Prisztina", quiz),
                new Question("Liechtenstein", "Vaduz", quiz),
                new Question("Litwa", "Wilno" , quiz),
                new Question("Luksemburg", "Luksemburg" , quiz),
                new Question("Łotwa", "Ryga" , quiz),
                new Question("Macedonia", "Skopje" , quiz),
                new Question("Malta", "Valletta" , quiz),
                new Question("Mołdawia", "Kiszyniów" , quiz),
                new Question("Monako", "Monako" , quiz),
                new Question("Niemcy", "Berlin" , quiz),
                new Question("Norwegia", "Oslo" , quiz),
                new Question("Polska", "Warszawa" , quiz),
                new Question("Portugalia", "Lizbona" , quiz),
                new Question("Rosja", "Moskwa" , quiz),
                new Question("Rumunia", "Bukareszt" , quiz),
                new Question("San Marino", "San Marino" , quiz),
                new Question("Serbia", "Belgrad" , quiz),
                new Question("Słowacja", "Bratysława" , quiz),
                new Question("Słowenia", "Lublana" , quiz),
                new Question("Szwajcaria", "Berno" , quiz),
                new Question("Szwecja", "Sztokholm" , quiz),
                new Question("Turcja", "Ankara" , quiz),
                new Question("Ukraina", "Kijów" , quiz),
                new Question("Watykan", "Watykan" , quiz),
                new Question("Węgry", "Budapeszt" , quiz),
                new Question("Wielka Brytania", "Londyn" , quiz),
                new Question("Włochy", "Rzym", quiz)
        ));
        //username: user
        //pass: 12345
        User user = new User();
        user.setUsername("user");
        user.setPassword("$2a$12$hlg1KLbR/C9jwpLFsZL.nOkpAk0FyAS08vDEluWF.j8tLBrORpk0e");
        user.setEmail("user@example.com");
        user.setRole(roleRepository.findRoleByName("USER"));
        user.setTier(tierRepository.findTierByTiername("PADAWAN"));
        userRepository.save(user);
        //username: admin
        //pass: 12345
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("$2a$12$hlg1KLbR/C9jwpLFsZL.nOkpAk0FyAS08vDEluWF.j8tLBrORpk0e");
        admin.setEmail("user@example.com");
        admin.setRole(roleRepository.findRoleByName("ADMIN"));
        userRepository.save(admin);
        //comment
        return "dashboard";
    }
}
