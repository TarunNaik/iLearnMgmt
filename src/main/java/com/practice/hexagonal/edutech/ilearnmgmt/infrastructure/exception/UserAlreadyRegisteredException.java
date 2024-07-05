package com.practice.hexagonal.edutech.ilearnmgmt.infrastructure.exception;

public class UserAlreadyRegisteredException extends RuntimeException {
    public UserAlreadyRegisteredException(String message) {
        super(message);
    }
}
