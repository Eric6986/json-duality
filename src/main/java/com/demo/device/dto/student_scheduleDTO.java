package com.demo.device.dto;

import com.demo.device.model.Metadata;
import com.demo.device.model.Schedule;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class student_scheduleDTO {

    private Integer id;
    private String student;
    private Metadata _metadata;
    private ArrayList<Schedule> schedule;

    public student_scheduleDTO(String json) throws JsonProcessingException {
        this.id = id;
        this.student = student;
        this.schedule = schedule;
        this._metadata = _metadata;
    }
}
