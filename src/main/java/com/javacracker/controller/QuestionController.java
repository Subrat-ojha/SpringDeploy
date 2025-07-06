package com.javacracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javacracker.entity.Question;
import com.javacracker.repository.QuestionRepository;

@Controller
public class QuestionController {

    @Autowired
    private QuestionRepository repo;

    @GetMapping("/questions")
    public String viewQuestions(
        @RequestParam(required = false) String company,
        @RequestParam(required = false) String difficulty,
        @RequestParam(defaultValue = "0") int page,
        Model model
    ) {
        Pageable pageable = PageRequest.of(page, 10);
        Page<Question> result = repo.filterQuestions(company, difficulty, pageable);

        model.addAttribute("questions", result.getContent());
        model.addAttribute("page", result);
        model.addAttribute("company", company);
        model.addAttribute("difficulty", difficulty);

        model.addAttribute("total",repo.getTotalCount());
        model.addAttribute("easy", repo.countByDifficulty("Easy"));
        model.addAttribute("medium", repo.countByDifficulty("Medium"));
        model.addAttribute("hard", repo.countByDifficulty("Hard"));

        return "questions";
    }
}
