package com.practice.hexagonal.edutech.ilearnmgmt.application.dao;

import com.practice.hexagonal.edutech.ilearnmgmt.adaptor.out.persistence.jpa.repository.UserRepository;
import com.practice.hexagonal.edutech.ilearnmgmt.application.port.out.UserDao;
import com.practice.hexagonal.edutech.ilearnmgmt.application.mapper.UserEntityMapper;
import com.practice.hexagonal.edutech.ilearnmgmt.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.Optional;
//@RequiredArgsConstructor
@Component
public class UserDaoImpl implements UserDao {
    UserRepository userRepository;
    UserEntityMapper userEntityMapper;
    public UserDaoImpl(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }
    @Override
    public User findUserByEmailId(String emailId) {
        com.practice.hexagonal.edutech.ilearnmgmt.adaptor.out.persistence.jpa.entity.User user = userRepository.findByEmail(emailId);
        return userEntityMapper.domainFromEntity(user);
    }

    @Override
    public String registerUser(User user) {
        userRepository.save(userEntityMapper.domainToEntity(user));
        return "Registered Successfully";
    }
}
