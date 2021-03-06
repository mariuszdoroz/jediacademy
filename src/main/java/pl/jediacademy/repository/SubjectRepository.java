package pl.jediacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jediacademy.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {

    Subject findByName(String name);
}
