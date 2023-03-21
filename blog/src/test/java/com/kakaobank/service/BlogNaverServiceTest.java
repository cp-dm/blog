package com.kakaobank.service;

import com.kakaobank.dto.response.BlogDocumentsResponseDto;
import com.kakaobank.dto.response.naver.BlogNaverItemResponseDto;
import com.kakaobank.dto.response.naver.BlogNaverResponseDto;
import com.kakaobank.dto.resquest.BlogRequestDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BlogNaverServiceTest {

    @InjectMocks
    BlogNaverService blogNaverService;
    @Mock
    private RestTemplate restTemplate;

    @Test
    @DisplayName("NAVER API 성공")
    void blog_NAVER_API_성공() {
        final String QUERY = "카카오뱅크";
        BlogRequestDto blogRequestDto = BlogRequestDto.builder().query(QUERY).build();

        List<BlogNaverItemResponseDto> blogDocumentsResponseDtoList = asList(BlogNaverItemResponseDto.builder().title("카카오뱅크 블로그").build());

        BlogNaverResponseDto blogNaverResponseDto = BlogNaverResponseDto.builder()
                .total(1)
                .start(1)
                .display(1)
                .items(blogDocumentsResponseDtoList)
                .build();
        ResponseEntity<BlogNaverResponseDto> responseBlogResponseDto = new ResponseEntity<>(blogNaverResponseDto, HttpStatus.OK);

        when(restTemplate.exchange(
                anyString(),
                any(HttpMethod.class),
                any(HttpEntity.class),
                ArgumentMatchers.<Class<BlogNaverResponseDto>>any())
        ).thenReturn(responseBlogResponseDto);

        Page<BlogDocumentsResponseDto> BlogDocumentsResponseDto = blogNaverService.blog(blogRequestDto);

        assertEquals(BlogDocumentsResponseDto.getContent().size(), 1);
        assertEquals(BlogDocumentsResponseDto.getContent().get(0).getTitle(), blogDocumentsResponseDtoList.get(0).getTitle());
    }

    @Test
    @DisplayName("NAVER API 실패")
    void blog_NAVER_API_실패() {
        final String QUERY = "카카오뱅크";
        BlogRequestDto blogRequestDto = BlogRequestDto.builder().query(QUERY).build();

        when(restTemplate.exchange(
                anyString(),
                any(HttpMethod.class),
                any(HttpEntity.class),
                ArgumentMatchers.<Class<BlogNaverResponseDto>>any())
        ).thenReturn(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));

        Assertions.assertThrows(RuntimeException.class, () -> {
            blogNaverService.blog(blogRequestDto);
        });
    }
}