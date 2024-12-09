package com.in28minutes.springboot.firstwebapp.hello;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@Controller
public class HelloController {

	@RequestMapping("say-hello")
	@ResponseBody
	public String sayhello() {
		return "Hey! what are u learning today ";
	}

	@RequestMapping("say-hello-jsp")
	public String sayhellojsp() {
		return "sayhello";
	}
	
}


