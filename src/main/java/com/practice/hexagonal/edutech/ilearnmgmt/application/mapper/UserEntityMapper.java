package com.practice.hexagonal.edutech.ilearnmgmt.application.mapper;

import com.practice.hexagonal.edutech.ilearnmgmt.adaptor.out.persistence.jpa.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    UserEntityMapper mapper = Mappers.getMapper(UserEntityMapper.class);

    public User domainToEntity(com.practice.hexagonal.edutech.ilearnmgmt.domain.entity.User user);
    public com.practice.hexagonal.edutech.ilearnmgmt.domain.entity.User domainFromEntity(User user);
}
