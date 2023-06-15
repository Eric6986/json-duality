package com.demo.device.repository;

import com.demo.device.model.Device;
import com.demo.device.model.student_documents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface student_documentsRepository extends MongoRepository<student_documents, Integer> {

    student_documents findById(long id);


}
