package com.likelion.intro2026.controller;

import com.likelion.intro2026.dto.RecommendRequest;
import com.likelion.intro2026.entity.Song;
import com.likelion.intro2026.service.RecommendService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class RecommendController {

    private final RecommendService recommendService;

    @Operation(
            summary = "노래 추천 - 김도윤",
            description = """
                genreIds(배열), keywordIds(배열)를 받아 조건에 맞는 노래 한 곡만을 랜덤으로 반환합니다.
                
                - song_id, genre_id, keyword_id, lyrics, singer, title을 반환합니다.
                - 이 중 title과 singer를 유튜브 링크에 넣는 구조로 지금 듣기 버튼 구현하시면 됩니다.
             
                """,
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "추천 성공",
                            content = @Content(
                                 schema = @Schema(implementation = Song.class)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "잘못된 요청 (genreIds 또는 keywordIds 누락)"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "song 테이블에 데이터 없음"
                    )
            }
    )

    @PostMapping("/recommend")
    public Song recommend(@Valid @RequestBody RecommendRequest req) {
        return recommendService.recommend(req.getGenreIds(), req.getKeywordIds());
    }
}
