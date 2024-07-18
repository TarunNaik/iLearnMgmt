package com.practice.hexagonal.edutech.ilearnmgmt.adaptor.out.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@ToString
@Data
@Entity
@Table(name = "User_Detail")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;


}
