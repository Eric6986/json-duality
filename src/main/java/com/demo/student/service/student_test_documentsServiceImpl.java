package com.demo.student.service;

import com.demo.student.model.student_documents;
import com.demo.student.repository.student_ords_documentsRepository;
import com.demo.student.repository.student_test_documentsRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class student_test_documentsServiceImpl implements student_test_documentsService {
    @Autowired
    private student_test_documentsRepository student_test_documentsRepository;

    @Autowired
    @Qualifier("testMongoTemplate")
    protected MongoTemplate mongoTemplate;

    @Override
    public List<student_documents> findAll() {
        return student_test_documentsRepository.findAll();
    }

    public Optional<student_documents> findById(Integer id) {

        return student_test_documentsRepository.findById(id);
    }

    public student_documents saveOrUpdateStudent(student_documents student_documents) {

        return student_test_documentsRepository.save(student_documents);
    }

    @Override
    public UpdateResult UpdateStudent(student_documents student_documents) {
        Query query = new Query().addCriteria(Criteria.where("_id").is(student_documents.getId())) ;
        Update updateDefinition = new Update().set("name", student_documents.getName());
        UpdateResult updateResult = mongoTemplate.updateFirst(query, updateDefinition, student_documents.class);
        return null;
    }


    @Override
    public void deleteStudentById(Integer id) {
        student_test_documentsRepository.deleteById(id);
    }
}
