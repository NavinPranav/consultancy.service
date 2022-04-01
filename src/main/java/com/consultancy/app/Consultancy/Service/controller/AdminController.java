package com.consultancy.app.Consultancy.Service.controller;


import com.consultancy.app.Consultancy.Service.dto.AdminDto;
import com.consultancy.app.Consultancy.Service.dto.CandidateDto;
import com.consultancy.app.Consultancy.Service.service.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin

public class AdminController {

    @Autowired
    private AdminServices adminService;

    @PostMapping("/login")
    public ResponseEntity<APIResponse> login(@RequestBody AdminDto adminDto) throws Exception {
        APIResponse response = new APIResponse();
        if(adminService.login(adminDto)){
            response.setStatus("SUCCESS");
            response.setMessage("login Success");
            HttpHeaders httpHeaders = new HttpHeaders();
            return new ResponseEntity<APIResponse>(response,HttpStatus.OK);
        }else{
            response.setStatus("FAILURE");
            response.setMessage("login failed");
            HttpHeaders httpHeaders = new HttpHeaders();
            return new ResponseEntity<APIResponse>(response,HttpStatus.BAD_REQUEST);
        }

    }

}
