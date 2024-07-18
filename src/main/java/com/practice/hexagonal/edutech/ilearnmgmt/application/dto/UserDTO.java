package com.practice.hexagonal.edutech.ilearnmgmt.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class UserDTO {

    private UUID id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty(message = "Email can not be empty")
    @Email
    private String email;
    @NotEmpty(message = "Password can not be empty")
    private String password;
}
