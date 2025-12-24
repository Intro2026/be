package com.likelion.intro2026.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class RecommendRequest {

    @NotEmpty
    List<Long> genreIds;
    @NotEmpty
    List<Long> keywordIds;
}
