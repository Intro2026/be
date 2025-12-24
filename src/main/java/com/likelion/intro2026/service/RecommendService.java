package com.likelion.intro2026.service;

import com.likelion.intro2026.entity.Song;
import com.likelion.intro2026.repository.GenreRepository;
import com.likelion.intro2026.repository.KeywordRepository;
import com.likelion.intro2026.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendService {
    private final SongRepository songRepository;
    private final GenreRepository genreRepository;
    private final KeywordRepository keywordRepository;

    public Song recommend (List<Long> genreIds, List<Long> keywordIds) {
        // 1. 장르 ID 검증
        for (Long id : genreIds) {
            if (!genreRepository.existsById(id)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 genreId: " + id);
            }
        }

        // 2. 키워드 ID 검증
        for (Long id : keywordIds) {
            if (!keywordRepository.existsById(id)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "존재하지 않는 keywordId: " + id);
            }
        }

        return songRepository.findRandom(genreIds, keywordIds)
                        .orElseThrow(() ->
                                new ResponseStatusException(HttpStatus.NOT_FOUND, "조건에 맞는 노래가 없습니다.")
                        );

    }

}
