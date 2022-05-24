package pl.jediacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jediacademy.model.Role;
import pl.jediacademy.model.Subject;
import pl.jediacademy.model.Tier;
import pl.jediacademy.model.User;
import pl.jediacademy.repository.RoleRepository;
import pl.jediacademy.repository.SubjectRepository;
import pl.jediacademy.repository.TierRepository;
import pl.jediacademy.repository.UserRepository;

import java.util.Arrays;


@Controller
@RequestMapping
public class DataController {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private TierRepository tierRepository;
    private SubjectRepository subjectRepository;

    public DataController(UserRepository userRepository, RoleRepository roleRepository, TierRepository tierRepository, SubjectRepository subjectRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.tierRepository = tierRepository;
        this.subjectRepository = subjectRepository;
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
