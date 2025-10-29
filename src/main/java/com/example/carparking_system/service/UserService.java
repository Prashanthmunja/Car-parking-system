package com.example.carparking_system.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.carparking_system.Model.user;
import com.example.carparking_system.Repository.userrepo;

@Service
public class UserService {
	private final userrepo repoistory;
	public UserService(userrepo repoistory) {
		this.repoistory=repoistory;
	}
		public user register(user u) {
			return repoistory.save(u);
		}
		public Optional<user>findByEmail(String email){
			return repoistory.findByEmail(email);
		
		
	}

}
