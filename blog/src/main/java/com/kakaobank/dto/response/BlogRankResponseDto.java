package com.kakaobank.dto.response;

import lombok.*;
import org.springframework.data.redis.core.ZSetOperations;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlogRankResponseDto {
    private String keyword;
    private int hit;
    public static BlogRankResponseDto of(ZSetOperations.TypedTuple<String> blogRank) {
        String keyword = blogRank.getValue();
        int score = (int) Math.round(blogRank.getScore());
        return BlogRankResponseDto.builder().keyword(keyword).hit(score).build();
    }

    public static BlogRankResponseDto convert(String keyword, int hit) {
        return BlogRankResponseDto.builder().keyword(keyword).hit(hit).build();
    }
}
