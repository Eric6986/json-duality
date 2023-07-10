package com.demo.student.service;

import com.demo.student.model.student_documents;
import com.mongodb.client.result.UpdateResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface student_ords_documentsService {
    List<student_documents> findAll();

    Optional<student_documents> findById(Integer id);

    student_documents saveOrUpdateStudent(student_documents student_documents);

    UpdateResult UpdateStudent(student_documents student_documents);

    void deleteStudentById(Integer id);

}
