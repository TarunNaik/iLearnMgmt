package com.practice.hexagonal.edutech.ilearnmgmt.application.port.in;

import com.practice.hexagonal.edutech.ilearnmgmt.application.dto.UserDTO;

public interface UserRegistrationUseCase {
    public String registerUser(UserDTO userDTO);
}
