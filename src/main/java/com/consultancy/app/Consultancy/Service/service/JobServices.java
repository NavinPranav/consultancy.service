package com.consultancy.app.Consultancy.Service.service;

import com.consultancy.app.Consultancy.Service.dto.JobDetailsDto;
import com.consultancy.app.Consultancy.Service.entity.JobDetails;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface JobServices {

    void createJob(JobDetailsDto jobDetailsDto);

    void deleteJob(String id);

    void editJob(String id, JobDetailsDto jobDetailsDto);

    JobDetailsDto findJob(String id);

    List<JobDetails> listJobs();

}
