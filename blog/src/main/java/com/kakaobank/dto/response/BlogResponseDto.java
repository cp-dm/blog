package com.kakaobank.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlogResponseDto {
    private BlogMetaResponseDto meta;
    private List<BlogDocumentsResponseDto> documents;
}
