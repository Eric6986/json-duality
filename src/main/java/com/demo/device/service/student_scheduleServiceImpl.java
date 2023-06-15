package com.demo.device.service;

import com.demo.device.model.student_documents;
import com.demo.device.model.student_schedule;
import com.demo.device.repository.student_scheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class student_scheduleServiceImpl implements student_scheduleService {
    @Autowired
    private student_scheduleRepository student_scheduleRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<student_schedule> findAll() {

        return student_scheduleRepository.findAll();
    }

    public Object findById(Integer id) {

        return student_scheduleRepository.findById(id);
    }

}
