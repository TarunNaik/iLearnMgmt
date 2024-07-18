package com.practice.hexagonal.edutech.ilearnmgmt.application.port.out;

import com.practice.hexagonal.edutech.ilearnmgmt.application.dto.UserDTO;
import com.practice.hexagonal.edutech.ilearnmgmt.domain.entity.User;

import java.util.Optional;

public interface UserDao {
    Optional<User> findUserByEmailId(String emailId);

    String registerUser(User user);
}
