package com.likelion.intro2026.service;

import com.likelion.intro2026.entity.Keyword;
import com.likelion.intro2026.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KeywordService {
    private final KeywordRepository keywordRepository;

    public List<Keyword> findAllKeywords() {
        return keywordRepository.findAll();
    }
}
