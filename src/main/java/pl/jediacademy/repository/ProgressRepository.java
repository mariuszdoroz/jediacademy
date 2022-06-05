package pl.jediacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.jediacademy.model.Progress;

import java.awt.print.Book;
import java.util.List;

public interface ProgressRepository extends JpaRepository<Progress,Long> {


    List<Progress> findAllByUserId(Long userid);

//    @Query("SELECT ROUND((SELECT SUM(goodanswers) FROM progress WHERE user_id= :userid)/(SELECT SUM(total) FROM progress WHERE user_id= :userid)*100)")
//    Long usereffectiveness(@Param("userid") Long userid);

}
