package com.fitstudentapp.server.studentservice;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public String createUser() {
        System.out.println("Create user Service");
        return null;
    }

}
