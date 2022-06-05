package pl.jediacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.jediacademy.model.Progress;

import java.util.List;

public interface ProgressRepository extends JpaRepository<Progress,Long> {

//    @Query("SELECT (SELECT SUM(goodanswers) FROM progress WHERE user_id= :userid)/(SELECT SUM(total) FROM progress WHERE user_id= :userid)")

    List<Progress> findAllByUserId(Long userid);

}
