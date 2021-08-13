package com.fitstudentapp.server.shared;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Utils {

    public String generateStudentId() {
        return UUID.randomUUID().toString();
    }

    public String extractMessage(Exception ex) {
        return ex.getLocalizedMessage() == null ? ex.toString() : ex.getLocalizedMessage();
    }

}
