package com.likelion.intro2026.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class RecommendRequest {

    @NotEmpty
    List<Integer> genreIds;
    @NotEmpty
    List<Integer> keywordIds;
}
