package com.consultancy.app.Consultancy.Service.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "candid")
@Data

public class Candidate {

    @Id
    private String id;

    @Field("name")
    private String name;

    @Field("phone")
    private String phone;

    @Field("email")
    private String email;

    @Field("dob")
    private String dob;

    @Field("gender")
    private String gender;

    @Field("experience")
    private String experience;

    @Field("skills")
    private String skills;

    @Field("education")
    private String education;

    @Field("achievement")
    private String achievement;

    @Field("status")
    private String status;

    @Field("apply")
    private String apply;

    @Field("jobStatus")
    private String jobStatus;
}
