package com.consultancy.app.Consultancy.Service.service;

import com.consultancy.app.Consultancy.Service.dto.AdminDto;
import com.consultancy.app.Consultancy.Service.dto.CandidateDto;
import com.consultancy.app.Consultancy.Service.entity.Candidate;
import org.springframework.stereotype.Service;

@Service

public interface AdminServices {
    Boolean login(AdminDto adminDto) throws Exception;


}
