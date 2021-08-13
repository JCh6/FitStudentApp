package com.fitstudentapp.server.shared;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Utils {
    public String generateStudentId() {
        return UUID.randomUUID().toString();
    }
}
