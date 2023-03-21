package com.kakaobank.service;

import com.kakaobank.dto.response.BlogDocumentsResponseDto;
import com.kakaobank.dto.response.BlogMetaResponseDto;
import com.kakaobank.dto.response.BlogResponseDto;
import com.kakaobank.dto.response.naver.BlogNaverItemResponseDto;
import com.kakaobank.dto.resquest.BlogRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BlogServiceTest {
    @InjectMocks
    BlogService blogService;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private BlogNaverService blogNaverService;
    @Mock
    private BlogRankService blogRankService;

    @Test
    @DisplayName("KaKao API 성공")
    void blog_KAKAO_API_성공() {
        final String QUERY = "카카오뱅크";
        BlogRequestDto blogRequestDto = BlogRequestDto.builder().query(QUERY).build();

        List<BlogDocumentsResponseDto> blogDocumentsResponseDtoList = asList(BlogDocumentsResponseDto.builder().blogname("카카오뱅크 블로그").build());

        BlogResponseDto blogResponseDto = BlogResponseDto.builder()
                .documents(blogDocumentsResponseDtoList)
                .meta(new BlogMetaResponseDto())
                .build();
        ResponseEntity<BlogResponseDto> responseBlogResponseDto = new ResponseEntity<>(blogResponseDto, HttpStatus.OK);

        when(restTemplate.exchange(
                anyString(),
                any(HttpMethod.class),
                any(HttpEntity.class),
                ArgumentMatchers.<Class<BlogResponseDto>>any())
        ).thenReturn(responseBlogResponseDto);

        Page<BlogDocumentsResponseDto> BlogDocumentsResponseDto = blogService.blog(blogRequestDto);

        assertEquals(BlogDocumentsResponseDto.getContent().size(), 1);
        assertEquals(BlogDocumentsResponseDto.getContent(), blogDocumentsResponseDtoList);
        verify(blogRankService, times(1)).saveRank(QUERY);
    }

    @Test
    @DisplayName("KaKao API 실패")
    void blog_KAKAO_API_실패() {
        final String QUERY = "카카오뱅크";
        BlogRequestDto blogRequestDto = BlogRequestDto.builder().query(QUERY).build();

        List<BlogDocumentsResponseDto> blogDocumentsResponseDtoList = asList(BlogDocumentsResponseDto.builder().blogname("카카오뱅크 블로그").build());

        Pageable pageable = PageRequest.of(blogRequestDto.getPage(), blogRequestDto.getSize());
        BlogNaverItemResponseDto blogNaverItemResponseDto = BlogNaverItemResponseDto.builder().bloggername("카카오뱅크 블로그").build();
        Page<BlogDocumentsResponseDto> responseSearchBlog = new PageImpl<>(asList(BlogDocumentsResponseDto.of(blogNaverItemResponseDto)), pageable, 1);

        when(restTemplate.exchange(
                anyString(),
                any(HttpMethod.class),
                any(HttpEntity.class),
                ArgumentMatchers.<Class<BlogResponseDto>>any())
        ).thenReturn(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
        when(blogNaverService.blog(blogRequestDto)).thenReturn(responseSearchBlog);

        Page<BlogDocumentsResponseDto> BlogDocumentsResponseDto = blogService.blog(blogRequestDto);

        assertEquals(BlogDocumentsResponseDto.getContent().size(), 1);
        assertEquals(BlogDocumentsResponseDto.getContent().get(0).getBlogname(), blogDocumentsResponseDtoList.get(0).getBlogname());
        verify(blogNaverService).blog(blogRequestDto);
        verify(blogRankService, times(1)).saveRank(QUERY);
    }
}