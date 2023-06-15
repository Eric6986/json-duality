package com.demo.device.service;

import com.demo.device.model.student_documents;
import com.demo.device.model.teacher_schedule;
import com.demo.device.repository.student_documentsRepository;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class student_documentsServiceImpl implements student_documentsService {
    @Autowired
    private student_documentsRepository student_documentsRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<student_documents> findAll() {
        return student_documentsRepository.findAll();
    }

    public Optional<student_documents> findById(Integer id) {

        return student_documentsRepository.findById(id);
    }

    public student_documents saveOrUpdateStudent(student_documents student_documents) {

        return student_documentsRepository.save(student_documents);
    }

    @Override
    public UpdateResult UpdateStudent(student_documents student_documents) {
        Query query = new Query().addCriteria(Criteria.where("_id").is(student_documents.getId())) ;
        Update updateDefinition = new Update().set("name", student_documents.getName());
        UpdateResult updateResult = mongoTemplate.updateFirst(query, updateDefinition, student_documents.class);
        return updateResult;
    }


    @Override
    public void deleteStudentById(Integer id) {
        student_documentsRepository.deleteById(id);
    }
}
