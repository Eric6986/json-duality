package com.demo.student.controller;

import com.demo.student.model.student_documents;
import com.demo.student.service.student_ords_documentsService;
import com.demo.student.service.student_test_documentsService;
import com.demo.student.util.ObjectMapperUtils;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/test/student_documents")
public class StudentTESTDocumentsController {
    final Logger logger = Logger.getLogger(StudentTESTDocumentsController.class.getName());

    @Autowired
    private student_test_documentsService student_test_documentsService;

    final HttpHeaders httpHeaders= new HttpHeaders();

    @GetMapping
    public List<Object> getAllStudentDocuments() {
        return ObjectMapperUtils.mapAll(student_test_documentsService.findAll(), Object.class);
    }

    @GetMapping(value = "/{id}")
    public Object getStudentDocumentsById(@PathVariable Integer id) {
        return student_test_documentsService.findById(id);
    }

    @PostMapping
    public ResponseEntity<?> saveOrUpdateStudent(@RequestBody student_documents student_documentsDTO) {
        try {
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            student_documents student_documents = student_test_documentsService.saveOrUpdateStudent(ObjectMapperUtils.map(student_documentsDTO, student_documents.class));
            //student_documents student_documents = student_documentsService.saveOrUpdateStudent(student_documents);

            return new ResponseEntity(student_documents, httpHeaders, HttpStatus.OK);
        } catch (Exception x) {
            return new ResponseEntity("{\"result\":\"" + x.getMessage() + "}", httpHeaders, HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping
    public ResponseEntity<?> UpdateStudent(@RequestBody student_documents student_documentsDTO) {
        try {
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            UpdateResult updateResult = student_test_documentsService.UpdateStudent(ObjectMapperUtils.map(student_documentsDTO, student_documents.class));
            //student_documents student_documents = student_documentsService.saveOrUpdateStudent(student_documents);

            return new ResponseEntity(updateResult, httpHeaders, HttpStatus.OK);
        } catch (Exception x) {
            return new ResponseEntity("{\"result\":\"" + x.getMessage() + "}", httpHeaders, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteStudentByStudentNumber(@PathVariable Integer id) {
        try {
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            student_test_documentsService.deleteStudentById(student_test_documentsService.findById(id).get().getId());
            return new ResponseEntity("{\"result\":\"SUCCESS\"}", httpHeaders, HttpStatus.OK);
        } catch (Exception x) {
            return new ResponseEntity("{\"result\":\"" + x.getMessage() + "}", httpHeaders, HttpStatus.BAD_REQUEST);
        }
    }
}
