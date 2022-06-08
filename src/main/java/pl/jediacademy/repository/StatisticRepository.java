package pl.jediacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.jediacademy.model.Statistic;

import java.util.List;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic,Long> {

    @Query(value = "SELECT * FROM statistic WHERE user_id = :userid and question_id = :questionid order by date DESC limit 10", nativeQuery = true)
    List<Statistic> findAllByQuestionIdUserId(@Param("userid") Long userid, @Param("questionid")Long questionid);

    @Query(value = "SELECT * FROM statistic WHERE user_id = :userid and quiz_id = :quizid order by date desc limit :limit", nativeQuery = true)
    List<Statistic> lastQuizAnswers(@Param("limit") Long limit, @Param("quizid") Long quizid, @Param("userid") Long userid);
}
