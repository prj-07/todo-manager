package com.in28minutes.springboot.firstwebapp.login;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;

@Controller
public class LoginController {

	//@Autowired
	private AuthBasic auth; 
	
	public LoginController(AuthBasic auth) {
		super();
		this.auth = auth;
	}


	@RequestMapping(value = "login",method = org.springframework.web.bind.annotation.RequestMethod.GET)
	public String gotologin() {
		//model.put("name",name);
		return "login";
	}
	
	
	@RequestMapping(value ="login",method = org.springframework.web.bind.annotation.RequestMethod.POST)
	public String gotowelcomepage(@RequestParam String name,@RequestParam String password,ModelMap model) {
		//model.put("name",name);
		model.put("name",name);

		if(auth.authenticate(name, password)) {
		model.put("name",name);
		return "welcome";
		}
		return "welcome";
	}
}
