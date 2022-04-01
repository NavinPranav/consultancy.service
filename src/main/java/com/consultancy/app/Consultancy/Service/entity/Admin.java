package com.consultancy.app.Consultancy.Service.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "admin")
@Data

public class Admin {

    @Field("username")
    private String username;

    @Field("password")
    private String password;



}
