package me.challenge.GenericRestApplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    private static final String MONGODB_URI = "mongodb://mongo/";

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
