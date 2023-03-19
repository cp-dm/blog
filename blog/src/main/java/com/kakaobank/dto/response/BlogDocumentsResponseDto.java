package com.kakaobank.dto.response;

import com.kakaobank.dto.response.naver.BlogNaverItemResponseDto;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlogDocumentsResponseDto {
    private String title;
    private String contents;
    private String url;
    private String blogname;
    private String thumbnail;
    private String datetime;

    public static BlogDocumentsResponseDto of(BlogNaverItemResponseDto searchBlogNaverItemResponseDto) {
        return BlogDocumentsResponseDto.builder()
                .title(searchBlogNaverItemResponseDto.getTitle())
                .contents(searchBlogNaverItemResponseDto.getDescription())
                .url(searchBlogNaverItemResponseDto.getLink())
                .blogname(searchBlogNaverItemResponseDto.getBloggername())
                .thumbnail("")
                .datetime(searchBlogNaverItemResponseDto.getPostdate())
                .build();
    }
}
