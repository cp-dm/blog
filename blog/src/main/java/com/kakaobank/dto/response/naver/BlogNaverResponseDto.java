package com.kakaobank.dto.response.naver;

import lombok.*;

import java.util.List;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogNaverResponseDto {
    private int total;
    private int start;
    private int display;
    private List<BlogNaverItemResponseDto> items;
}
