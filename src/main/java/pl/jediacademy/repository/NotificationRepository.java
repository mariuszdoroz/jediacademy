package pl.jediacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jediacademy.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long> {

}