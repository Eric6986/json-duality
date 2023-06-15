package com.demo.device.service;

import com.demo.device.model.student_documents;
import com.demo.device.model.student_schedule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface student_scheduleService {
    List<student_schedule> findAll();

    Object findById(Integer id);

}
