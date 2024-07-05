package com.practice.hexagonal.edutech.ilearnmgmt.application.usecase;

import com.practice.hexagonal.edutech.ilearnmgmt.application.dao.UserDao;
import com.practice.hexagonal.edutech.ilearnmgmt.application.dto.UserDTO;
import com.practice.hexagonal.edutech.ilearnmgmt.application.port.in.UserRegistrationUseCase;
import com.practice.hexagonal.edutech.ilearnmgmt.domain.entity.User;
import com.practice.hexagonal.edutech.ilearnmgmt.infrastructure.exception.UserAlreadyRegisteredException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserRegistrationUseCaseImpl implements UserRegistrationUseCase {

    private UserDao userDao;

    public String registerUser(UserDTO userDTO) throws UserAlreadyRegisteredException {
        //check if User is already registered, email id is unique
        Optional<User> user = userDao.findUserByEmailId(userDTO.getEmail());
        if(user.isPresent()) {
            throw new UserAlreadyRegisteredException("User already registered");
        }
        return userDao.registerUser(userDTO);
    }
}
