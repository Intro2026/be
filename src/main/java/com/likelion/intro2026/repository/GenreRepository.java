package com.likelion.intro2026.repository;

import com.likelion.intro2026.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    long countByGenreIdIn(List<Long> genreIds);
}