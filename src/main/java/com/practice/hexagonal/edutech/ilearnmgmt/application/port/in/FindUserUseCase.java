package com.practice.hexagonal.edutech.ilearnmgmt.application.port.in;

import com.practice.hexagonal.edutech.ilearnmgmt.application.dto.UserDTO;
import com.practice.hexagonal.edutech.ilearnmgmt.domain.entity.User;

public interface FindUserUseCase {
    public UserDTO findUserByEmail(String email);
}
