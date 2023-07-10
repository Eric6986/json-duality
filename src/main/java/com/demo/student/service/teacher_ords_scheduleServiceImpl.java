package com.demo.student.service;

import com.demo.student.model.teacher_schedule;
import com.demo.student.repository.teacher_ords_scheduleRepository;
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
public class teacher_ords_scheduleServiceImpl implements teacher_ords_scheduleService {
    @Autowired
    private teacher_ords_scheduleRepository teacher_ords_scheduleRepository;

    @Autowired
    @Qualifier("ordsMongoTemplate")
    protected MongoTemplate mongoTemplate;

    @Override
    public List<teacher_schedule> findAll() {

        return teacher_ords_scheduleRepository.findAll();
    }

    public Optional<teacher_schedule> findById(Integer id) {

        return teacher_ords_scheduleRepository.findById(id);
    }

    @Override
    public teacher_schedule saveOrUpdateTeacherSchedule(teacher_schedule teacher_schedule) {
        return teacher_ords_scheduleRepository.save(teacher_schedule);
    }

    @Override
    public UpdateResult UpdateTeacherSchedule(teacher_schedule teacher_schedule) {
        Query query = new Query().addCriteria(Criteria.where("_id").is(teacher_schedule.getId())) ;
        Update updateDefinition = new Update().set("teacher", teacher_schedule.getTeacher());
        UpdateResult updateResult = mongoTemplate.updateFirst(query, updateDefinition, teacher_schedule.class);
        return updateResult;
    }

    @Override
    public void deleteTeacherScheduleById(Integer id) {
        teacher_ords_scheduleRepository.deleteById(id);
    }

}
