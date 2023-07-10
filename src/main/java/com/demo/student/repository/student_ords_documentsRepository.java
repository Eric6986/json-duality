package com.demo.student.repository;

import com.demo.student.model.student_documents;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface student_ords_documentsRepository extends MongoRepository<student_documents, Integer> {
    student_documents findById(ObjectId id);
}
