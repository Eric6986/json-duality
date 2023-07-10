package com.demo.student.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;

@Getter
@Setter
@Document(collection = "teacher_schedule")
public class teacher_schedule {
    @MongoId
    public Integer id;
    public Object _metadata;
    public ArrayList<Course> courses;
    public Integer salary;
    public String teacher;
}