package com.ead.notification.services.impl;

import com.ead.notification.model.NotificationModel;
import com.ead.notification.repositories.NotificationRepository;
import com.ead.notification.services.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public NotificationModel saveNotification(NotificationModel notificationModel) {
        return notificationRepository.save(notificationModel);
    }
}
