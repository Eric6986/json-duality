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
@Document(collection = "student_schedule")
public class student_schedule {
    @MongoId
    public Integer id;
    public String student;
    public Object _metadata;
    public ArrayList<Schedule> schedule;
}