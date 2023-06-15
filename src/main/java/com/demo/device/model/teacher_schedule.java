package com.demo.device.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;

@Getter
@Setter
@Document(collection = "teacher_schedule")
public class teacher_schedule {
    @Id
    public Integer id;
    public Object _metadata;
    public ArrayList<Course> courses;
    public Integer salary;
    public String teacher;
}