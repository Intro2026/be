package com.likelion.intro2026.repository;

import com.likelion.intro2026.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SongRepository extends JpaRepository<Song, Long> {

    @Query(value = """
        SELECT * 
        FROM song 
        WHERE genre_id IN (:genreIds)
          AND keyword_id IN (:keywordIds)
        ORDER BY RAND()
        LIMIT 1
    """, nativeQuery = true)
    Optional<Song> findRandom(
            @Param("genreIds") List<Long> genreIds,
            @Param("keywordIds") List<Long> keywordIds
    );

    @Query(value = "SELECT * FROM song ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Song> findAnyRandom();

}
