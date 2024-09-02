package com.ms.ecommerce.notification.reposistory;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.ecommerce.notification.Notification;

public interface NotificationReposistory extends MongoRepository<Notification, String> {

}
