package com.consultancy.app.Consultancy.Service.dao;

import com.consultancy.app.Consultancy.Service.dto.CandidateDto;
import com.consultancy.app.Consultancy.Service.entity.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidRepo extends MongoRepository<Candidate,String> {
    
    Candidate findByEmail(String Email);

    Candidate findByEmailAndStatus(String id, String status);

}
