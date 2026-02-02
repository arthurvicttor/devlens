package com.devlens.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubAnalysisService {

    private final RestTemplate restTemplate;

    public GithubAnalysisService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> analyzeUser(String username) {

        String url = "https://api.github.com/users/" + username + "/repos?per_page=100";

        List<Map<String, Object>> repos =
                restTemplate.getForObject(url, List.class);

        Map<String, Integer> languages = new HashMap<>();
        List<String> suggestions = new ArrayList<>();
        List<String> strengths = new ArrayList<>();

        if (repos != null) {
            for (Map<String, Object> repo : repos) {

                Boolean isFork = (Boolean) repo.get("fork");
                if (Boolean.TRUE.equals(isFork)) continue;

                String language = (String) repo.get("language");

                if (language != null) {
                    languages.put(
                        language,
                        languages.getOrDefault(language, 0) + 1
                    );
                }
            }
        }

        int totalRepos = repos != null ? repos.size() : 0;

        // Strength simples
        if (totalRepos > 0) {
            strengths.add("Possui projetos públicos");
        }

        if (languages.size() >= 3) {
            strengths.add("Boa diversidade de linguagens");
        }

        // Sugestões simples
        if (languages.size() < 3) {
            suggestions.add("Criar projetos mais diversificados em diferentes linguagens");
        }

        if (totalRepos < 5) {
            suggestions.add("Criar mais projetos para fortalecer o portfólio");
        }

        if (languages.isEmpty()) {
            suggestions.add("Adicionar projetos com linguagens populares como JavaScript, Python ou Java");
        }

        if (suggestions.isEmpty()) {
            suggestions.add("Ótimo trabalho! Continue assim.");
        }
        

        return Map.of(
            "username", username,
            "totalRepositories", totalRepos,
            "languages", languages,
            "score", calculateScore(totalRepos, languages),
            "strengths", strengths,
            "suggestions", suggestions
        );
    }

    private int calculateScore(int totalRepos, Map<String, Integer> languages) {
        int score = 0;

        score += Math.min(totalRepos * 5, 50);
        score += Math.min(languages.size() * 10, 50);

        return score;
    }
}
