package com.fitstudentapp.server.ui.model.request;

import javax.validation.constraints.Email;

public class StudentUpdateRequestModel {
    private String name;

    @Email
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
