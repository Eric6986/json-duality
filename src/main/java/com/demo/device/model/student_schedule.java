package com.demo.device.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.ArrayList;

@Getter
@Setter
@Document(collection = "student_schedule")
public class student_schedule {
    @Id
    public Integer id;
    public String student;
    public Object _metadata;
    public ArrayList<Schedule> schedule;
}