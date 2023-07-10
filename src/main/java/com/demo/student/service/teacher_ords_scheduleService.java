package com.demo.student.service;

import com.demo.student.model.teacher_schedule;
import com.mongodb.client.result.UpdateResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface teacher_ords_scheduleService {
    List<teacher_schedule> findAll();

    Optional<teacher_schedule> findById(Integer id);

    teacher_schedule saveOrUpdateTeacherSchedule(teacher_schedule teacher_schedule);

    UpdateResult UpdateTeacherSchedule(teacher_schedule teacher_schedule);

    void deleteTeacherScheduleById(Integer id);
}
