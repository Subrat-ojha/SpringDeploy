package com.javacracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JavaCrackerController {

	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
}
	