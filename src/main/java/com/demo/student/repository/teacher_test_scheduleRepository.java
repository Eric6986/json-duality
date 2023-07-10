package com.demo.student.repository;

import com.demo.student.model.teacher_schedule;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface teacher_test_scheduleRepository extends MongoRepository<teacher_schedule, Integer> {
    teacher_schedule findById(ObjectId id);
    void deleteById(ObjectId id);
}
