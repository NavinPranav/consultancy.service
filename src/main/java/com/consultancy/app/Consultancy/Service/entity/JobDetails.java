package com.consultancy.app.Consultancy.Service.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "jobs")
public class JobDetails {
    @Id
    private String id;

    @Field("jobName")
    private String jobName;

    @Field("role")
    private String role;

    @Field("description")
    private String description;

    @Field("skills")
    private List<String> skills;

    @Field("experience")
    private String experience;

    @Field("status")
    private String status;

}
