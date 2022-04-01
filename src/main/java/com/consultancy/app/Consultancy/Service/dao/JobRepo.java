package com.consultancy.app.Consultancy.Service.dao;

import com.consultancy.app.Consultancy.Service.entity.JobDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends MongoRepository<JobDetails, String> {



}
