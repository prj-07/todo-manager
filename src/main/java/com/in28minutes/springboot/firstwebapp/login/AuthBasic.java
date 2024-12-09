package com.in28minutes.springboot.firstwebapp.login;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AuthBasic {

	public boolean authenticate(String Username,String Password) {
		boolean valuser = Username.equalsIgnoreCase("pratyush");
		boolean valpass = Password.equalsIgnoreCase("prj");
		return (valuser && valpass);
	}
}
