package com.demo.student.config;

import com.demo.student.repository.*;
import com.demo.student.service.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(
        value = {"com.demo.student"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*_ords_.*")},
        includeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*_test_.*")},
        mongoTemplateRef = "testMongoTemplate"
)
public class TestMongoDBRepositoryConfig {

    @Bean(name = "testMongoProperties")
    @ConfigurationProperties(prefix = "spring.mongodb.data.testdb")
    public MongoProperties getTEST() {
        return new MongoProperties();
    }


    @Bean(name = "testMongoDatabaseFactory")
    public MongoDatabaseFactory testMongoDatabaseFactory(@Qualifier("testMongoProperties") MongoProperties mongoProperties) {
        return new SimpleMongoClientDatabaseFactory(mongoProperties.getUri());
    }

    @Bean(name = "testMongoTemplate")
    public MongoTemplate testMongoTemplate() {
        return new MongoTemplate(testMongoDatabaseFactory(getTEST()));
    }
}
