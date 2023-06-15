package com.demo.device.repository;

import com.demo.device.model.student_schedule;
import com.demo.device.model.teacher_schedule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface teacher_scheduleRepository extends MongoRepository<teacher_schedule, Integer> {

    teacher_schedule findById(long id);


}
