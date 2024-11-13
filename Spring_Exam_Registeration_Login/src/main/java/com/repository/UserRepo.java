package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.UserEntity;


public interface UserRepo extends JpaRepository<UserEntity, Integer>{
UserEntity findById(int id);
}
