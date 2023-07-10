package com.demo.student.service;

import com.demo.student.model.student_documents;
import com.demo.student.model.student_schedule;
import com.demo.student.model.teacher_schedule;
import com.mongodb.client.result.UpdateResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface student_ords_scheduleService {

    List<student_schedule> findAll();

    Optional<student_schedule> findById(Integer id);

    student_schedule saveOrUpdateStudentSchedule(student_schedule student_schedule);

    UpdateResult UpdateStudentSchedule(student_schedule student_schedule);

    void deleteStudentScheduleById(Integer id);


}
