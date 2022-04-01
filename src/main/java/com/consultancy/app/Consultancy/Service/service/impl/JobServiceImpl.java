package com.consultancy.app.Consultancy.Service.service.impl;

import com.consultancy.app.Consultancy.Service.dao.JobRepo;
import com.consultancy.app.Consultancy.Service.dto.JobDetailsDto;
import com.consultancy.app.Consultancy.Service.entity.JobDetails;
import com.consultancy.app.Consultancy.Service.service.JobServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobServices {

    @Autowired
    private JobRepo jobRepo;

    @Override
    public List<JobDetails> listJobs() {
        return jobRepo.findAll();
    }

    @Override
    public void createJob(JobDetailsDto jobDetailsDto) {
        JobDetails jobDetails = new JobDetails();
        jobDetails.setJobName(jobDetailsDto.getJobName());
        jobDetails.setDescription(jobDetailsDto.getDescription());
        jobDetails.setRole(jobDetailsDto.getRole());
        jobDetails.setSkills(jobDetailsDto.getSkills());
        jobDetails.setExperience(jobDetailsDto.getExperience());
        jobDetails.setStatus("active");
        jobRepo.insert(jobDetails);
    }

    @Override
    public void deleteJob(String id) {
        Optional<JobDetails> jobDetailsOptional = jobRepo.findById(id);
        JobDetails tobedeleted = jobDetailsOptional.get();
        tobedeleted.setStatus("Inactive");
        jobRepo.save(tobedeleted);
    }

    @Override
    public void editJob(String id, JobDetailsDto jobDetailsDto) {
        Optional<JobDetails> jobDetailsOptional = jobRepo.findById(id);
        JobDetails jobDetails = jobDetailsOptional.get();
        jobDetails.setJobName(jobDetailsDto.getJobName());
        jobDetails.setDescription(jobDetailsDto.getDescription());
        jobDetails.setRole(jobDetailsDto.getRole());
        jobDetails.setSkills(jobDetailsDto.getSkills());
        jobDetails.setExperience(jobDetailsDto.getExperience());
        jobRepo.save(jobDetails);
    }

    @Override
    public JobDetailsDto findJob(String id){
        JobDetailsDto jobDetailsDto = new JobDetailsDto();
        Optional<JobDetails> jobDetailsOptional = jobRepo.findById(id);
        JobDetails jobDetails = jobDetailsOptional.get();
        jobDetailsDto.setJobName(jobDetails.getJobName());
        jobDetailsDto.setDescription(jobDetails.getDescription());
        jobDetailsDto.setRole(jobDetails.getRole());
        jobDetailsDto.setSkills(jobDetails.getSkills());
        jobDetailsDto.setExperience(jobDetails.getExperience());
        return jobDetailsDto;
    }
}
