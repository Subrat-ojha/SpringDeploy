package com.javacracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JavaCrackerController {

	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/learn")
	public String goLearn() {
		return "learn";
	}
	
	@GetMapping("/top5books")
	public String gotop5books() {
		return "top5books";
	}
	
	
	@GetMapping("/interviewquestions")
	public String goInterviewQuestions() {
		return "/interviewquestions";
	}
	@GetMapping("/cheatsheet")
	public String goCheatsheet() {
		return "cheatsheet";
	}
	@GetMapping("/blog")
	public String goBlog() {
		return "blog";
	}
	
	@GetMapping("/projects")
	public String goProjects() {
		return "projects";
	}

	
}
	