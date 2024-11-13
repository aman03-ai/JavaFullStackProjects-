package com.service;

import com.entity.UserEntity;

public interface UserService {
public boolean registerUser(UserEntity user);
public UserEntity loginUser(int id,String pass);
}
