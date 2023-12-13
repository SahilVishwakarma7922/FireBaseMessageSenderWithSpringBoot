package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.NotificationRequest;
import com.example.demo.service.NotificationService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
@RestController
//@CrossOrigin(origins ="*")
public class NotificationController {

	
	 @PostMapping("/sendNotification")
	    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
	        // Extract notification details from request
	        String title = request.getTitle();
	        String body = request.getBody();
	        String targetToken = request.getTargetToken();

	        // Create notification message
	        Message message = Message.builder()
	                .putData("title", title)
	                .putData("body", body)
	                .setToken(targetToken)
	                .build();
	        try {
	            FirebaseMessaging.getInstance().send(message);
	            return ResponseEntity.ok("Notification sent successfully!");
	        } catch (Exception e) {
	            return ResponseEntity.status(500).body("Error sending notification: " + e.getMessage());
	        }
	    }
//	 
//	@Autowired
//	private NotificationService notificationService;
//	
//	 @PostMapping("/sendNotification")
//	    public ResponseEntity<String> sendNotification(@RequestBody NotificationRequest request) {
//	     
//	        try {
//	        	notificationService.sendNotification(request.getTitle(), request.getBody(), request.getTargetToken());
//	            return ResponseEntity.ok("Notification sent successfully!");
//	        } catch (Exception e) {
//	            return ResponseEntity.status(500).body("Error sending notification: " + e.getMessage());
//	        }
//	    }
}
