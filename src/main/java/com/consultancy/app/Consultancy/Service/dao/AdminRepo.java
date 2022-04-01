package com.consultancy.app.Consultancy.Service.dao;

import com.consultancy.app.Consultancy.Service.entity.Admin;
import lombok.Data;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository


public interface AdminRepo extends MongoRepository<Admin,String> {

    Admin findByUsername(String userName);


}