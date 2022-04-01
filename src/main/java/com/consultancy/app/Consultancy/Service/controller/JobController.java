package com.consultancy.app.Consultancy.Service.controller;

import com.consultancy.app.Consultancy.Service.dto.CandidateDto;
import com.consultancy.app.Consultancy.Service.dto.JobDetailsDto;
import com.consultancy.app.Consultancy.Service.service.CandidServices;
import com.consultancy.app.Consultancy.Service.service.JobServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job")
@CrossOrigin

public class JobController {

    @Autowired
    private JobServices jobService;

    @GetMapping("{id}")
    public ResponseEntity<APIResponse> getJob(@PathVariable String id){
        APIResponse response = new APIResponse();
        response.setData(jobService.findJob(id));
        response.setStatus("SUCCESS");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getJobs(){
        APIResponse response = new APIResponse();
        response.setData(jobService.listJobs());
        response.setStatus("SUCCESS");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<APIResponse> createJob(@RequestBody JobDetailsDto jobDetailsDto){
        APIResponse response = new APIResponse();
        jobService.createJob(jobDetailsDto);
        response.setMessage("job created");
        response.setStatus("Success");
        return new ResponseEntity<APIResponse>(response, HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<APIResponse> editJob(@PathVariable String id, @RequestBody JobDetailsDto jobDetailsDto){
        APIResponse response = new APIResponse();
        jobService.editJob(id, jobDetailsDto);
        response.setMessage("job edited");
        response.setStatus("Success");
        return new ResponseEntity<APIResponse>(response,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse> deleteJob(@PathVariable String id){
        APIResponse response = new APIResponse();
        jobService.deleteJob(id);
        response.setMessage("job deleted");
        response.setStatus("Success");
        return new ResponseEntity<APIResponse>(response,HttpStatus.OK);
    }
}
