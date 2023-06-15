package com.demo.device.controller;

import com.demo.device.dto.student_documentsDTO;
import com.demo.device.model.student_documents;
import com.demo.device.service.student_documentsService;
import com.demo.device.util.ObjectMapperUtils;
import com.mongodb.DBObject;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/collections/student_documents")
public class StudentDocumentsController {
    final Logger logger = Logger.getLogger(StudentDocumentsController.class.getName());
    @Autowired
    private student_documentsService student_documentsService;

    final HttpHeaders httpHeaders= new HttpHeaders();


    @GetMapping(value = "/")
    public List<Object> getAllStudentDocuments() {
        return ObjectMapperUtils.mapAll(student_documentsService.findAll(), Object.class);
    }


    @GetMapping(value = "/{id}")
    public Object getStudentDocumentsById(@PathVariable Integer id) {
        return student_documentsService.findById(id);
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> saveOrUpdateStudent(@RequestBody student_documents student_documentsDTO) {
        try {
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            student_documents student_documents = student_documentsService.saveOrUpdateStudent(ObjectMapperUtils.map(student_documentsDTO, student_documents.class));
            //student_documents student_documents = student_documentsService.saveOrUpdateStudent(student_documents);

            return new ResponseEntity(student_documents, httpHeaders, HttpStatus.OK);
        } catch (Exception x) {
            return new ResponseEntity("{\"result\":\"" + x.getMessage() + "}", httpHeaders, HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(value = "/")
    public ResponseEntity<?> UpdateStudent(@RequestBody student_documents student_documentsDTO) {
        try {
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            UpdateResult updateResult = student_documentsService.UpdateStudent(ObjectMapperUtils.map(student_documentsDTO, student_documents.class));
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
            student_documentsService.deleteStudentById(student_documentsService.findById(id).get().getId());
            return new ResponseEntity("{\"result\":\"SUCCESS\"}", httpHeaders, HttpStatus.OK);
        } catch (Exception x) {
            return new ResponseEntity("{\"result\":\"" + x.getMessage() + "}", httpHeaders, HttpStatus.BAD_REQUEST);
        }
    }

}
