package pl.jediacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jediacademy.model.Statistic;

@Repository
public interface StatisticRepository extends JpaRepository<Statistic,Long> {
}
