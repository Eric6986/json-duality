package com.demo.device.dto;

import com.demo.device.model.Course;
import com.demo.device.model.Metadata;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class teacher_scheduleDTO {


    private Integer id;
    private Metadata _metadata;
    private ArrayList<Course> courses;
    private Integer salary;
    private String teacher;

    public teacher_scheduleDTO(String json) throws JsonProcessingException {
        this.id = id;
        this.courses = courses;
        this.salary = salary;
        this._metadata = _metadata;
        this.teacher = teacher;
    }
}
