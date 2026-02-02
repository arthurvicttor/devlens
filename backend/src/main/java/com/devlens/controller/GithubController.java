package com.devlens.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devlens.service.GithubAnalysisService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/github")
public class GithubController {

    private final GithubAnalysisService service;

    public GithubController(GithubAnalysisService service) {
        this.service = service;
    }

    @GetMapping("/analyze/{username}")
    public Map<String, Object> analyze(@PathVariable String username) {
        return service.analyzeUser(username);
    }
}
