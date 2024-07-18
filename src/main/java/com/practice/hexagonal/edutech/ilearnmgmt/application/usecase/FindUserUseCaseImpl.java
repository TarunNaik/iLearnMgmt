package com.practice.hexagonal.edutech.ilearnmgmt.application.usecase;

import com.practice.hexagonal.edutech.ilearnmgmt.application.port.out.UserDao;
import com.practice.hexagonal.edutech.ilearnmgmt.application.dto.UserDTO;
import com.practice.hexagonal.edutech.ilearnmgmt.application.mapper.UserDomainMapper;
import com.practice.hexagonal.edutech.ilearnmgmt.application.port.in.FindUserUseCase;
import com.practice.hexagonal.edutech.ilearnmgmt.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.Optional;
//@RequiredArgsConstructor
@Component
public class FindUserUseCaseImpl implements FindUserUseCase {
    UserDao userDao;
    UserDomainMapper mapper;
    public FindUserUseCaseImpl (UserDao userDao, UserDomainMapper mapper) {
        this.userDao = userDao;
        this.mapper = mapper;
    }
    @Override
    public UserDTO findUserByEmail(String email) {
        Optional<User> user = userDao.findUserByEmailId(email);
        return user.isPresent() ? mapper.UserDtoFromUser(user.get()) : null;
    }
}
