package com.demo.device.repository;

import com.demo.device.model.student_documents;
import com.demo.device.model.student_schedule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface student_scheduleRepository extends MongoRepository<student_schedule, Integer> {

    student_schedule findById(long id);


}
