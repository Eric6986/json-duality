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
        includeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*_ords_.*")},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*_test_.*")},
        mongoTemplateRef = "ordsMongoTemplate"
)
public class OrdsMongoDBRepositoryConfig {

    @Bean(name = "ordsMongoProperties")
    @ConfigurationProperties(prefix = "spring.mongodb.data.ordsdb")
    @Primary
    public MongoProperties getORDS() {
        return new MongoProperties();
    }

    @Primary
    @Bean(name = "ordsMongoDatabaseFactory")
    public MongoDatabaseFactory ordsMongoDatabaseFactory(@Qualifier("ordsMongoProperties") MongoProperties mongoProperties) {
        return new SimpleMongoClientDatabaseFactory(mongoProperties.getUri());
    }

    @Primary
    @Bean(name = "ordsMongoTemplate")
    public MongoTemplate ordsMongoTemplate() {
        return new MongoTemplate(ordsMongoDatabaseFactory(getORDS()));
    }
}
