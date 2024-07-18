package com.practice.hexagonal.edutech.ilearnmgmt.application.mapper;

import com.practice.hexagonal.edutech.ilearnmgmt.application.dto.UserDTO;
import com.practice.hexagonal.edutech.ilearnmgmt.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserDomainMapper {
    UserDomainMapper mapper = Mappers.getMapper(UserDomainMapper.class);

    UserDTO UserDtoFromUser(User user);
    User userDtoToUser(UserDTO userDTO);
}
