package com.consultancy.app.Consultancy.Service.service.impl;

import com.consultancy.app.Consultancy.Service.dao.AdminRepo;
import com.consultancy.app.Consultancy.Service.dto.AdminDto;
import com.consultancy.app.Consultancy.Service.dto.CandidateDto;
import com.consultancy.app.Consultancy.Service.entity.Admin;
import com.consultancy.app.Consultancy.Service.entity.Candidate;
import com.consultancy.app.Consultancy.Service.service.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminServices {

    @Autowired
    private AdminRepo adminRepo;
    public Boolean login(AdminDto adminDto) throws Exception {
        try{
            Admin admin = adminRepo.findByUsername(adminDto.getUsername());
            return adminDto.getPassword().matches(admin.getPassword());
        }catch (Exception e){
            throw new Exception("Admin not logged",e);
        }
        }



    }
