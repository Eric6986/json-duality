package com.demo.student.model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Getter
@Setter
@Document(collection = "student_documents")
public class student_documents{
    @MongoId
    public Integer id;
    public String name;
    public Object info;
    public Object _metadata;
}