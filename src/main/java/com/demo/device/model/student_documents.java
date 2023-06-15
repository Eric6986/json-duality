package com.demo.device.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Document(collection = "student_documents")
public class student_documents{
    @Id
    public Integer id;
    public String name;
    public Object info;
    public Object _metadata;
}