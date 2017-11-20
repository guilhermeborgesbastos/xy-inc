/*
 * AppConfig.java
 *
 * Tech Test Programming Exercise Zup
 * Before the configuration startts this class should be loaded
 * @version    0.1.0
 * @author     Guilherme Borges Bastos
*/
package me.challenge.GenericRestApplication.config;

// >> imports
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

@Configuration
public class AppConfig {

    private static final String MONGODB_URI = "mongodb://localhost/";

    @Bean
    public MongoClient mongoClient() {
        System.out.println("mongoClient() >> ");
        MongoClientURI uri = new MongoClientURI(MONGODB_URI);
        return new MongoClient(uri);
    }

    @Bean
    @Autowired
    public MongoDatabase mongoDatabase(MongoClient mongoClient) {
        return mongoClient.getDatabase("admin");
    }

}
