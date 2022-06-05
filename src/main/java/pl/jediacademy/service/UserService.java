package pl.jediacademy.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.jediacademy.model.User;
import pl.jediacademy.repository.RoleRepository;
import pl.jediacademy.repository.TierRepository;
import pl.jediacademy.repository.UserRepository;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TierRepository tierRepository;
    private final RoleRepository roleRepository;


    public UserService(UserRepository userRepository, TierRepository tierRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.tierRepository = tierRepository;
        this.roleRepository = roleRepository;
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User editUser(String username) {
        User user = userRepository.findByUsername(username);
        user.setPassword(null);
        return user;
    }

    public List<User> findAll() {
        return  userRepository.findAll();
    }

    public void save(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setTier(tierRepository.findTierByTiername("PADAWAN"));
        user.setRole(roleRepository.findRoleByName("USER"));
        userRepository.save(user);
    }

    public void update(User user) {
        User updateUser = userRepository.getUserById(user.getId());
        updateUser.setUsername(user.getUsername());
        updateUser.setEmail(user.getEmail());
        if(user.getPassword().equals("")) {
            user.setPassword(updateUser.getPassword());
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            updateUser.setPassword(encodedPassword);
        }
        userRepository.save(updateUser);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
