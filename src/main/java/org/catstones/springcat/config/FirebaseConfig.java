package org.catstones.springcat.config;

import java.io.IOException;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirebaseConfig {
  @Bean
  FirebaseApp createFireBaseApp() throws IOException {
    FirebaseOptions options =
        new FirebaseOptions.Builder().setCredentials(GoogleCredentials.getApplicationDefault())
            .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/").build();

    return FirebaseApp.initializeApp(options);
  }
}
