package com.trungtam.DemoSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@PropertySource(value = "classpath:msg/message.properties")
public class HelloController {
	
	@Autowired
	Environment environment;
	
	@Autowired
	MessageSource messageSource;
	
	@Value(value = "${title}")
	String title;
	
	@GetMapping(value = "/hello")
	public String getDefault(Model model) {
		// truyen truc tiep
		model.addAttribute("message", "Spring boot");
		
		// Dung message Source && phai khai bao spring.messages.basename o application.pro   --- message.properties
		model.addAttribute("messageSource", messageSource.getMessage("name", null, null));
		
		// Dung environment && @PropertySource   --- message.properties
		model.addAttribute("messageEnvironment", environment.getProperty("name"));
		
		// Dung @value && Khai bao o application.pro  --- application.properties
		model.addAttribute("applicationValue", title);
		
		// Dung environment && Khai bao o application.pro  --- application.properties
		model.addAttribute("applicationEnvironment", environment.getProperty("title"));
		
		return "index";
	}
	
}
