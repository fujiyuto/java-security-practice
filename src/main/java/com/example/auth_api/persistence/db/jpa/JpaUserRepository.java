package com.example.auth_api.persistence.db.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auth_api.persistence.db.entity.UserEntity;

public interface JpaUserRepository extends JpaRepository<UserEntity,Long> {

}
