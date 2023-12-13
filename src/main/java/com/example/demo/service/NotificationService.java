package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
@Service
public class NotificationService {
//for git testing 
	
	  public void sendNotification(String title, String body, String targetToken) {
	        Message message = Message.builder()
	                .putData("title", title)
	                .putData("body", body)
	                .setToken(targetToken)
//                .setToken("asdfghjkkloplkjhfdgsfgsdfgsfdgsdfgsdfgsdfg")
	                .build();

	        try {
	            FirebaseMessaging.getInstance().send(message);
	            System.out.println("Notification sent successfully!");
	        } catch (Exception e) {
	            System.out.println("Error sending notification: " + e.getMessage());
	        }
	    }
}
