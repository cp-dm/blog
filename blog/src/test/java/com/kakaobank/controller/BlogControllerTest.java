package com.kakaobank.controller;

import com.kakaobank.dto.response.BlogDocumentsResponseDto;
import com.kakaobank.dto.resquest.BlogRequestDto;
import com.kakaobank.service.BlogService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BlogControllerTest {

    @InjectMocks
    private BlogController blogController;
    @Mock
    private BlogService blogService;

    @Test
    @DisplayName("블로그 검색 Controller Test")
    void blog() {
        BlogRequestDto blogRequestDto = BlogRequestDto.builder().query("카카오뱅크").build();
        Pageable pageable = PageRequest.of(blogRequestDto.getPage(), blogRequestDto.getSize());
        Page<BlogDocumentsResponseDto> responseSearchBlog = new PageImpl<>(asList(), pageable, 1);

        when(blogService.blog(blogRequestDto)).thenReturn(responseSearchBlog);

        Page<BlogDocumentsResponseDto> searchBlogDocumentsResponseDto = blogController.blog(blogRequestDto);

        assertEquals(searchBlogDocumentsResponseDto, responseSearchBlog);
        verify(blogService).blog(blogRequestDto);
    }
}