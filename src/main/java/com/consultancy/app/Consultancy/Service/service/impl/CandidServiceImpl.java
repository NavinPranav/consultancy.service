package com.consultancy.app.Consultancy.Service.service.impl;

import com.consultancy.app.Consultancy.Service.dao.AdminRepo;
import com.consultancy.app.Consultancy.Service.dao.CandidRepo;
import com.consultancy.app.Consultancy.Service.dto.CandidateDto;
import com.consultancy.app.Consultancy.Service.entity.Candidate;
import com.consultancy.app.Consultancy.Service.entity.JobDetails;
import com.consultancy.app.Consultancy.Service.service.CandidServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidServiceImpl implements CandidServices {

    @Autowired
    private CandidRepo candidRepo;

    @Override
    public CandidateDto findCandid(String id) {
        CandidateDto candidateDto = new CandidateDto();
        Optional<Candidate> candidateOptional =  candidRepo.findById(id);
        System.out.println(candidateOptional);
        Candidate candidate=candidateOptional.get();
        candidateDto.setId(candidate.getId());
        candidateDto.setName(candidate.getName());
        candidateDto.setPhone(candidate.getPhone());
        candidateDto.setEmail(candidate.getEmail());
        candidateDto.setDob(candidate.getDob());
        candidateDto.setGender(candidate.getGender());
        candidateDto.setExperience(candidate.getExperience());
        candidateDto.setSkills(candidate.getSkills());
        candidateDto.setEducation(candidate.getEducation());
        candidateDto.setAchievement(candidate.getAchievement());
        candidateDto.setApply(candidate.getApply());
        candidateDto.setJobStatus(candidate.getJobStatus());
        candidateDto.setStatus(candidate.getStatus());
        return candidateDto;
    }

    @Override
    public List<Candidate> listCandid() {
        return candidRepo.findAll();
    }

    @Override
    public CandidateDto candidLogin(String email) {
        CandidateDto candidateDto = new CandidateDto();

        Candidate candidate =  candidRepo.findByEmailAndStatus(email,"active");
        candidateDto.setName(candidate.getName());
        candidateDto.setPhone(candidate.getPhone());
        candidateDto.setEmail(candidate.getEmail());
        candidateDto.setDob(candidate.getDob());
        candidateDto.setGender(candidate.getGender());
        candidateDto.setExperience(candidate.getExperience());
        candidateDto.setSkills(candidate.getSkills());
        candidateDto.setEducation(candidate.getEducation());
        candidateDto.setAchievement(candidate.getAchievement());
        candidateDto.setApply(candidate.getApply());
        candidateDto.setJobStatus(candidate.getJobStatus());
        candidateDto.setStatus(candidate.getStatus());
//        System.out.println(candidateDto);
        return candidateDto;
    }

    @Override
    public void createCandidate(CandidateDto candidateDto){
        Candidate candidate = new Candidate();
        candidate.setName(candidateDto.getName());
        candidate.setPhone(candidateDto.getPhone());
        candidate.setEmail(candidateDto.getEmail());
        candidate.setDob(candidateDto.getDob());
        candidate.setGender(candidateDto.getGender());
        candidate.setExperience(candidateDto.getExperience());
        candidate.setSkills(candidateDto.getSkills());
        candidate.setEducation(candidateDto.getEducation());
        candidate.setAchievement(candidateDto.getAchievement());
        candidate.setApply(candidateDto.getApply());
        candidate.setJobStatus(candidateDto.getJobStatus());
        candidate.setStatus("active");
        candidRepo.insert(candidate);
        System.out.println(candidate);
    }

    @Override
    public void deleteCandidate(String id) {
        Optional<Candidate> candidateOptional =  candidRepo.findById(id);
        Candidate candidate=candidateOptional.get();
        candidate.setStatus("Inactive");
        candidRepo.save(candidate);
    }

    @Override
    public void editCandidate(String id, CandidateDto candidateDto) {
        Optional<Candidate> candidateOptional =  candidRepo.findById(id);
//        System.out.println(candidateOptional + "asd");
        Candidate candidate=candidateOptional.get();
        if(candidateDto.getName()!=null){
            candidate.setName(candidateDto.getName());
        }
        if(candidateDto.getPhone() != null){
            candidate.setPhone(candidateDto.getPhone());
        }
        if(candidateDto.getEmail() != null){
            candidate.setEmail(candidateDto.getEmail());
        }
        if(candidateDto.getDob() != null){
            candidate.setDob(candidateDto.getDob());
        }
        if(candidateDto.getGender() != null){
            candidate.setGender(candidateDto.getGender());
        }
        if(candidateDto.getExperience() != null){
            candidate.setExperience(candidateDto.getExperience());
        }
        if(candidateDto.getSkills() != null){
            candidate.setSkills(candidateDto.getSkills());
        }
        if(candidateDto.getEducation() != null){
            candidate.setEducation(candidateDto.getEducation());
        }
        if(candidateDto.getAchievement() != null){
            candidate.setAchievement(candidateDto.getAchievement());
        }
        if(candidateDto.getApply() != null){
            candidate.setApply(candidateDto.getApply());
        }
        if(candidateDto.getJobStatus() != null){
            candidate.setJobStatus(candidateDto.getJobStatus());
        }
        candidRepo.save(candidate);
    }
}
