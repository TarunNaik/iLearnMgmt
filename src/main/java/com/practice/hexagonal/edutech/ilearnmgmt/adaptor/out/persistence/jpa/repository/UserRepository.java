package com.practice.hexagonal.edutech.ilearnmgmt.adaptor.out.persistence.jpa.repository;

import com.practice.hexagonal.edutech.ilearnmgmt.adaptor.out.persistence.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
