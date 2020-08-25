package com.ifi.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class StaffDTO {

    @NotNull(message = "First Name cannot be null")
    private String firstName;

    @NotNull(message = "Last Name cannot be null")
    private String lastName;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Not valid email")
    private String email;
}


