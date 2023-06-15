package com.demo.device.dto;

import com.demo.device.model.Metadata;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class student_documentsDTO {
    private double id;
    private String name;
    private Object info;
    private Metadata _metadata;

    public student_documentsDTO(String json) throws JsonProcessingException {
        this.id = id;
        this.name = name;
        this.info = info;
        this._metadata = _metadata;
    }
}
