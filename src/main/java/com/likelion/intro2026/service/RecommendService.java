package com.likelion.intro2026.service;

import com.likelion.intro2026.entity.Song;
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

    public Song recommend (List<Integer> genreIds, List<Integer> keywordIds) {
        return songRepository.findRandom(genreIds, keywordIds)
                .orElseGet(() ->
                        songRepository.findAnyRandom()
                            .orElseThrow(() ->
                                    new IllegalStateException("song 테이블 비어 있음")
                            )
                );
    }

}
