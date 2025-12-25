package com.likelion.intro2026.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name="song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id", nullable = false)
    private Long songId;

    @Column(name = "singer", nullable = false)
    private String singer;

    @Column(name = "title")
    private String title;

    @Column(name = "lyrics", nullable = false)
    private String lyrics;

    @Column(nullable = false)
    private Long genreId;

    @Column(nullable = false)
    private Long keywordId;
}
