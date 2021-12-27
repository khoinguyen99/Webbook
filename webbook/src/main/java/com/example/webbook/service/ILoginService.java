package com.example.webbook.service;

import java.util.Optional;

import com.example.webbook.entity.LoginEntity;

public interface ILoginService {

	int login(String username, String pass, Boolean isLoginAdmin);

	

}
