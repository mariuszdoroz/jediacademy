package pl.jediacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.jediacademy.model.Progress;

import java.awt.print.Book;
import java.util.List;

public interface ProgressRepository extends JpaRepository<Progress,Long> {


    List<Progress> findAllByUserId(Long userid);

    @Query(value="SELECT * FROM progress WHERE user_id = :userid and quiz_id = :quizid", nativeQuery = true)
    List<Progress> findAllByQuizIdAndUserId(@Param("userid") Long userid, @Param("quizid") Long quizid);

}
