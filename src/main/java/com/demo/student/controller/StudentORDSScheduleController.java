package com.demo.student.controller;

import com.demo.student.model.student_schedule;
import com.demo.student.model.teacher_schedule;
import com.demo.student.service.student_ords_scheduleService;
import com.demo.student.service.student_test_scheduleService;
import com.demo.student.service.teacher_ords_scheduleService;
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
@RequestMapping(value = "/api/ords/student_schedule")
public class StudentORDSScheduleController {
    final Logger logger = Logger.getLogger(StudentORDSScheduleController.class.getName());
    @Autowired
    private student_ords_scheduleService student_ords_scheduleService;
    final HttpHeaders httpHeaders= new HttpHeaders();

    @GetMapping
    public List<student_schedule> getAllStudentSchedule() {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        return ObjectMapperUtils.mapAll(student_ords_scheduleService.findAll(), student_schedule.class);
    }

    @PostMapping
    public ResponseEntity<?> saveOrUpdateStudentSchedule(@RequestBody student_schedule student_scheduleDTO) {
        try {
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            student_schedule updateResult = student_ords_scheduleService.saveOrUpdateStudentSchedule(ObjectMapperUtils.map(student_scheduleDTO, student_schedule.class));
            return new ResponseEntity(updateResult, httpHeaders, HttpStatus.OK);
        } catch (Exception x) {
            return new ResponseEntity("{\"result\":\"" + x.getMessage() + "}", httpHeaders, HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping
    public ResponseEntity<?> UpdateTeacherScheduleColumn(@RequestBody student_schedule student_scheduleDTO) {
        try {
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            UpdateResult updateResult = student_ords_scheduleService.UpdateStudentSchedule(ObjectMapperUtils.map(student_scheduleDTO, student_schedule.class));
            //return ResponseHandler.generateResponse("Successfully added Teacher Schedule data!", HttpStatus.OK, teacher_schedule);
            return new ResponseEntity(updateResult, httpHeaders, HttpStatus.OK);
        } catch (Exception x) {
            return new ResponseEntity("{\"result\":\"" + x.getMessage() + "}", httpHeaders, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteTeacherScheduleByScheduleNumber(@PathVariable Integer id) {
        try {
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            student_ords_scheduleService.deleteStudentScheduleById(student_ords_scheduleService.findById(id).get().getId());
            return new ResponseEntity("{\"result\":\"SUCCESS\"}", httpHeaders, HttpStatus.OK);
        } catch (Exception x) {
            return new ResponseEntity("{\"result\":\"" + x.getMessage() + "}", httpHeaders, HttpStatus.BAD_REQUEST);
        }
    }


}
