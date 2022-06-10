package pl.jediacademy.service;

import org.springframework.stereotype.Service;
import pl.jediacademy.model.Notification;
import pl.jediacademy.repository.NotificationRepository;

import java.util.Collections;
import java.util.List;

@Service
public class NotificationService {

    private NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }


    public String scoreNotification() {
        List<Notification> allNotification= notificationRepository.findAll();
        Collections.shuffle(allNotification);
        return allNotification.get(0).getMessage();
    }

}
