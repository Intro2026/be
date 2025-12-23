package com.likelion.intro2026.repository;

import com.likelion.intro2026.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
}
