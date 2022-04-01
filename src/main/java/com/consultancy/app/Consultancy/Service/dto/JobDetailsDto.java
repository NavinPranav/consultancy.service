package com.consultancy.app.Consultancy.Service.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
public class JobDetailsDto {

    private String id;

    private String jobName;

    private String role;

    private String description;

    private List<String> skills;

    private String experience;

    private String status;


}
