package com.kakaobank.controller;

import com.kakaobank.dto.response.BlogRankResponseDto;
import com.kakaobank.service.BlogRankService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BlogRankControllerTest {

    @InjectMocks
    private BlogRankController blogRankController;
    @Mock
    private BlogRankService blogRankService;

    @Test
    @DisplayName("인기 검색어 랭킹 Controller Test")
    void blogRank() {
        when(blogRankService.rank()).thenReturn(getBlogRankResponseDtoList());

        List<BlogRankResponseDto> searchPopularResponseDtoList = blogRankController.blogRank();

        assertEquals(searchPopularResponseDtoList.toString(), getBlogRankResponseDtoList().toString());
        verify(blogRankService).rank();
    }

    private List<BlogRankResponseDto> getBlogRankResponseDtoList() {
        List<BlogRankResponseDto> searchPopularDtoList = asList(
                BlogRankResponseDto.builder().keyword("카카오뱅크").hit(2).build(),
                BlogRankResponseDto.builder().keyword("카카오").hit(20).build(),
                BlogRankResponseDto.builder().keyword("뱅크").hit(5).build(),
                BlogRankResponseDto.builder().keyword("RED").hit(16).build(),
                BlogRankResponseDto.builder().keyword("개발").hit(8).build(),
                BlogRankResponseDto.builder().keyword("개발자").hit(45).build(),
                BlogRankResponseDto.builder().keyword("테스트").hit(33).build(),
                BlogRankResponseDto.builder().keyword("GIT").hit(1).build(),
                BlogRankResponseDto.builder().keyword("여름").hit(92).build(),
                BlogRankResponseDto.builder().keyword("겨울").hit(77).build()
        );
        return searchPopularDtoList;
    }
}