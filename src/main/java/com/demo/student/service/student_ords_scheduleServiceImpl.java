package com.demo.student.service;

import com.demo.student.model.student_documents;
import com.demo.student.model.student_schedule;
import com.demo.student.repository.student_ords_scheduleRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class student_ords_scheduleServiceImpl implements student_ords_scheduleService {
    @Autowired
    private student_ords_scheduleRepository student_ords_scheduleRepository;

    @Autowired
    @Qualifier("ordsMongoTemplate")
    protected MongoTemplate mongoTemplate;

    @Override
    public List<student_schedule> findAll() {

        return student_ords_scheduleRepository.findAll();
    }

    public Optional<student_schedule> findById(Integer id) {

        return student_ords_scheduleRepository.findById(id);
    }


    @Override
    public student_schedule saveOrUpdateStudentSchedule(student_schedule student_schedule) {

        return student_ords_scheduleRepository.save(student_schedule);

    }

    @Override
    public UpdateResult UpdateStudentSchedule(student_schedule student_schedule) {
        Query query = new Query().addCriteria(Criteria.where("_id").is(student_schedule.getId())) ;
        Update updateDefinition = new Update().set("student", student_schedule.getStudent());
        UpdateResult updateResult = mongoTemplate.updateFirst(query, updateDefinition, student_schedule.class);
        return null;
    }

    @Override
    public void deleteStudentScheduleById(Integer id) {
        student_ords_scheduleRepository.deleteById(id);
    }

}
