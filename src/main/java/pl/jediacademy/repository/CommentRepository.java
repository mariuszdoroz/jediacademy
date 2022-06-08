package pl.jediacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.jediacademy.model.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findAllByUserId(Long userid);
    @Query(value = "SELECT * FROM comment WHERE quiz_id = :quizid", nativeQuery = true)
    List<Comment> findcommentsquizid(@Param("quizid") Long quizid);
}
