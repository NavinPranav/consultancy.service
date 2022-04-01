package com.consultancy.app.Consultancy.Service.controller;


import com.consultancy.app.Consultancy.Service.dto.CandidateDto;
import com.consultancy.app.Consultancy.Service.service.AdminServices;
import com.consultancy.app.Consultancy.Service.service.CandidServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class CandidateController {

    @Autowired
    private CandidServices candidService;

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse> getCandidate(@PathVariable String id){
            APIResponse response = new APIResponse();
            response.setData(candidService.findCandid(id));
            response.setStatus("SUCCESS");
            return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getCandidates(){
        APIResponse response = new APIResponse();
        response.setData(candidService.listCandid());
        response.setStatus("SUCCESS");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse> userLogin(@RequestBody Map<String,String> email){
        APIResponse response = new APIResponse();
        if(candidService.candidLogin(email.get("email"))!=null){
            response.setMessage("user logged in successfully");
            response.setStatus("Success");
            response.setData(candidService.candidLogin(email.get("email")));
            HttpHeaders httpHeaders = new HttpHeaders();
            return new ResponseEntity<APIResponse>(response, HttpStatus.OK);
        }else{
            response.setMessage("username not found");
            response.setStatus("Failure");
            HttpHeaders httpHeaders = new HttpHeaders();
            return new ResponseEntity<APIResponse>(response, HttpStatus.NOT_FOUND);

        }
    }

    @PostMapping("/create")
    public ResponseEntity<APIResponse> createCandid(@RequestBody CandidateDto candidateDto){
        APIResponse response = new APIResponse();
        candidService.createCandidate(candidateDto);
        response.setMessage("Candidate created");
        response.setStatus("Success");
        return new ResponseEntity<APIResponse>(response,HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<APIResponse> editCandid(@PathVariable String id, @RequestBody CandidateDto candidateDto){
        APIResponse response = new APIResponse();
        candidService.editCandidate(id, candidateDto);
        response.setMessage("Candidate edited");
        response.setStatus("Success");
        return new ResponseEntity<APIResponse>(response,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<APIResponse> deleteCandid(@PathVariable String id){
        APIResponse response = new APIResponse();
        candidService.deleteCandidate(id);
        response.setMessage("Candidate deleted");
        response.setStatus("Success");
        return new ResponseEntity<APIResponse>(response,HttpStatus.OK);
    }

}
