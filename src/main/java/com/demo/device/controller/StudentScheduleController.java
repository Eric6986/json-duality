package com.demo.device.controller;

import com.demo.device.model.student_schedule;
import com.demo.device.service.student_scheduleService;
import com.demo.device.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/collections/student_schedule")
public class StudentScheduleController {
    final Logger logger = Logger.getLogger(StudentScheduleController.class.getName());
    @Autowired
    private student_scheduleService student_scheduleService;

    final HttpHeaders httpHeaders= new HttpHeaders();

    @GetMapping(value = "/")
    public List<student_schedule> getAllStudentSchedule() {
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        return ObjectMapperUtils.mapAll(student_scheduleService.findAll(), student_schedule.class);
    }


}
