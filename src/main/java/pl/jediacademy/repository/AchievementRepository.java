package pl.jediacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jediacademy.model.Achievement;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement,Long> {
}
