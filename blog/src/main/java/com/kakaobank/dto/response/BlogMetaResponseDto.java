package com.kakaobank.dto.response;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlogMetaResponseDto {
    private int totalCount;
    private int pageableCount;
    private boolean isEnd;
}
