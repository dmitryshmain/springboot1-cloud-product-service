package com.dataart.dshmain.boottest1.configuration;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.dataart.dshmain.boottest1.repository")
@EnableMongoAuditing
public class MongoConfiguration {

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Bean
    public MongoOperations mongoTemplate() {
        MongoOperations ops = new MongoTemplate(mongoClient(), database);
        return ops;
    }

    @Bean
    public MongoClient mongoClient() {
        return new MongoClient();
    }
}