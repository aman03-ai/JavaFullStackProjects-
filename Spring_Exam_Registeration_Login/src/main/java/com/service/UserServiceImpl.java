package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.UserEntity;
import com.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userrepo;
	

	@Override
	public boolean registerUser(UserEntity user) {
		// TODO Auto-generated method stub
		try {
			userrepo.save(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public UserEntity loginUser(int id,String pass) {
		// TODO Auto-generated method stub
		UserEntity valid= userrepo.findById(id);
		if(valid!=null && valid.getPass().equals(pass))
			return valid;
		else return null;
	}

}
