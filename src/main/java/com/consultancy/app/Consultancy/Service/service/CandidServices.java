package com.consultancy.app.Consultancy.Service.service;

import com.consultancy.app.Consultancy.Service.dto.CandidateDto;
import com.consultancy.app.Consultancy.Service.entity.Candidate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Service
public interface CandidServices {

    List<Candidate> listCandid();

    CandidateDto candidLogin(String email);

    CandidateDto findCandid(String id);

    void createCandidate(CandidateDto candidateDto);

    void deleteCandidate(String id);

    void editCandidate(String id, CandidateDto candidateDto);

}
