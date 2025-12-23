package com.likelion.intro2026.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name="keyword")
public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyword_id", nullable = false)
    private Long keywordId;

    @Column(name = "keyword", nullable = false)
    private String keyword;
}
