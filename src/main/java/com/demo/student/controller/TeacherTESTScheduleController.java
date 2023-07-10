package com.demo.student.controller;

import com.demo.student.model.teacher_schedule;
import com.demo.student.service.teacher_ords_scheduleService;
import com.demo.student.service.teacher_test_scheduleService;
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
@RequestMapping(value = "/api/test/teacher_schedule")
public class TeacherTESTScheduleController {
    final Logger logger = Logger.getLogger(TeacherTESTScheduleController.class.getName());
    @Autowired
    private teacher_test_scheduleService teacher_test_scheduleService;
    final HttpHeaders httpHeaders= new HttpHeaders();


    @GetMapping
    public List<Object> getAllTeacherSchedule() {
        return ObjectMapperUtils.mapAll(teacher_test_scheduleService.findAll(), Object.class);
    }


    @PostMapping
    public ResponseEntity<?> saveOrUpdateTeacherSchedule(@RequestBody teacher_schedule teacher_scheduleDTO) {
        try {
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            teacher_schedule updateResult = teacher_test_scheduleService.saveOrUpdateTeacherSchedule(ObjectMapperUtils.map(teacher_scheduleDTO, teacher_schedule.class));
            //return ResponseHandler.generateResponse("Successfully added Teacher Schedule data!", HttpStatus.OK, teacher_schedule);
            return new ResponseEntity(updateResult, httpHeaders, HttpStatus.OK);
        } catch (Exception x) {
            return new ResponseEntity("{\"result\":\"" + x.getMessage() + "}", httpHeaders, HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping
    public ResponseEntity<?> UpdateTeacherScheduleColumn(@RequestBody teacher_schedule teacher_scheduleDTO) {
        try {
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            UpdateResult updateResult = teacher_test_scheduleService.UpdateTeacherSchedule(ObjectMapperUtils.map(teacher_scheduleDTO, teacher_schedule.class));
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
            teacher_test_scheduleService.deleteTeacherScheduleById(teacher_test_scheduleService.findById(id).get().getId());
            return new ResponseEntity("{\"result\":\"SUCCESS\"}", httpHeaders, HttpStatus.OK);
        } catch (Exception x) {
        return new ResponseEntity("{\"result\":\"" + x.getMessage() + "}", httpHeaders, HttpStatus.BAD_REQUEST);
        }
    }
}
