package com.likelion.intro2026.repository;

import com.likelion.intro2026.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}