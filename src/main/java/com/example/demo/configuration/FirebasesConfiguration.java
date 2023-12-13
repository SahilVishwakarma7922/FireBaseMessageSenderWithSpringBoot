package com.example.demo.configuration;

import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
@Configuration
public class FirebasesConfiguration {

	 @PostConstruct
	    public void initialize() {
	        try {
	            FileInputStream serviceAccount =
	                    new FileInputStream("src/main/resources/nihal.json");

	            FirebaseOptions options = new FirebaseOptions.Builder()
	                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
	                    .build();

	            FirebaseApp.initializeApp(options);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
}
