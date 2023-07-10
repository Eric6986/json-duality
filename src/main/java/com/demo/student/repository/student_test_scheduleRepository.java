package com.demo.student.repository;

import com.demo.student.model.student_schedule;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface student_test_scheduleRepository extends MongoRepository<student_schedule, Integer> {

    student_schedule findById(long id);
}
