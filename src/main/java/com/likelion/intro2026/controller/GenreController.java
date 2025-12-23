package com.likelion.intro2026.controller;

import com.likelion.intro2026.entity.Genre;
import com.likelion.intro2026.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @GetMapping("/")
    public ResponseEntity<List<Genre>> getGenres() {
        List<Genre> genres = genreService.findAllGenres();
        return ResponseEntity.ok(genres);
    }
}
