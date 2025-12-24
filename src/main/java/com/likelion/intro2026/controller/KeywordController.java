package com.likelion.intro2026.controller;

import com.likelion.intro2026.entity.Keyword;
import com.likelion.intro2026.service.KeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/keyword")
@RequiredArgsConstructor
public class KeywordController {
    private final KeywordService keywordService;

    @GetMapping("/")
    public ResponseEntity<List<Keyword>> getKeywords() {
        List<Keyword> keywords = keywordService.findAllKeywords();
        return ResponseEntity.ok(keywords);
    }
}
