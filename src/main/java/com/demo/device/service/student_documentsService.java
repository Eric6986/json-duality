package com.demo.device.service;

import com.demo.device.model.student_documents;
import com.mongodb.client.result.UpdateResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface student_documentsService {
    List<student_documents> findAll();

    Optional<student_documents> findById(Integer id);

    student_documents saveOrUpdateStudent(student_documents student_documents);

    UpdateResult UpdateStudent(student_documents student_documents);

    void deleteStudentById(Integer id);

}
