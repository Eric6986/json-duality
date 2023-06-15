package com.demo.device.controller;

import com.demo.device.handler.ResponseHandler;
import com.demo.device.model.student_documents;
import com.demo.device.model.student_schedule;
import com.demo.device.model.teacher_schedule;
import com.demo.device.service.student_scheduleService;
import com.demo.device.service.teacher_scheduleService;
import com.demo.device.util.ObjectMapperUtils;
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
@RequestMapping(value = "/api/collections/teacher_schedule")
public class TeacherScheduleController {
    final Logger logger = Logger.getLogger(TeacherScheduleController.class.getName());
    @Autowired
    private teacher_scheduleService teacher_scheduleService;
    final HttpHeaders httpHeaders= new HttpHeaders();


    @GetMapping(value = "/")
    public List<Object> getAllTeacherSchedule() {
        return ObjectMapperUtils.mapAll(teacher_scheduleService.findAll(), Object.class);
    }


    @PostMapping(value = "/")
    public ResponseEntity<?> saveOrUpdateTeacherSchedule(@RequestBody teacher_schedule teacher_scheduleDTO) {
        try {
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            teacher_schedule updateResult = teacher_scheduleService.saveOrUpdateTeacherSchedule(ObjectMapperUtils.map(teacher_scheduleDTO, teacher_schedule.class));
            //return ResponseHandler.generateResponse("Successfully added Teacher Schedule data!", HttpStatus.OK, teacher_schedule);
            return new ResponseEntity(updateResult, httpHeaders, HttpStatus.OK);
        } catch (Exception x) {
            return new ResponseEntity("{\"result\":\"" + x.getMessage() + "}", httpHeaders, HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(value = "/")
    public ResponseEntity<?> UpdateTeacherScheduleColumn(@RequestBody teacher_schedule teacher_scheduleDTO) {
        try {
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            UpdateResult updateResult = teacher_scheduleService.UpdateTeacherSchedule(ObjectMapperUtils.map(teacher_scheduleDTO, teacher_schedule.class));
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
            teacher_scheduleService.deleteTeacherScheduleById(teacher_scheduleService.findById(id).get().getId());
            return new ResponseEntity("{\"result\":\"SUCCESS\"}", httpHeaders, HttpStatus.OK);
        } catch (Exception x) {
        return new ResponseEntity("{\"result\":\"" + x.getMessage() + "}", httpHeaders, HttpStatus.BAD_REQUEST);
    }
    }

}
