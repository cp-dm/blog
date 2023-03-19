package com.kakaobank.service;

import com.kakaobank.dto.response.BlogDocumentsResponseDto;
import com.kakaobank.dto.response.naver.BlogNaverResponseDto;
import com.kakaobank.dto.resquest.BlogRequestDto;
import com.kakaobank.enumeration.NaverSort;
import com.kakaobank.util.URLUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
@Slf4j
public class BlogNaverService {
    @Value("${api.naver.url}")
    String url;

    @Value("${api.naver.client-id}")
    String CLIENT_ID;

    @Value("${api.naver.client-secret}")
    String CLIENT_SECRET;

    private final RestTemplate restTemplate;
    public Page<BlogDocumentsResponseDto> searchBlog(BlogRequestDto blogRequestDto) {
        String blogURL = getUrl(blogRequestDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("X-Naver-Client-Id", CLIENT_ID);
        httpHeaders.add("X-Naver-Client-Secret", CLIENT_SECRET);

        HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<BlogNaverResponseDto> blogResponseDtoResponseEntity =
                restTemplate.exchange(blogURL, HttpMethod.GET, requestEntity, BlogNaverResponseDto.class);
        if (isNotSuccess(blogResponseDtoResponseEntity.getStatusCode())) {
            log.error("naver api error responseBody " + blogResponseDtoResponseEntity.getBody());
            throw new RuntimeException("naver api error");
        }

        BlogNaverResponseDto blogResponseDto = blogResponseDtoResponseEntity.getBody();

        Pageable pageable = PageRequest.of(blogRequestDto.getPage(), blogRequestDto.getSize());

        List<BlogDocumentsResponseDto> searchBlogDocumentsResponseDto = blogResponseDto
                .getItems()
                .stream()
                .map(BlogDocumentsResponseDto::of)
                .collect(toList());

        Page<BlogDocumentsResponseDto> responseSearchBlog = new PageImpl<>(searchBlogDocumentsResponseDto, pageable, blogResponseDto.getTotal());

        return responseSearchBlog;
    }

    private boolean isNotSuccess(HttpStatus statusCode) {
        return !statusCode.is2xxSuccessful();
    }

    private String getUrl(BlogRequestDto blogRequestDto) {
        final String BLOG_PATH = "blog.json";

        String searchBlogURL = url + BLOG_PATH + "?query=" + URLUtil.encodeUTF8(blogRequestDto.getQuery());

        URLUtil.urlSettingParameter(url, "sort", NaverSort.findSort(blogRequestDto.getSort()));
        URLUtil.urlSettingParameter(url, "start", blogRequestDto.getPage());
        URLUtil.urlSettingParameter(url, "display", blogRequestDto.getSize());

        return searchBlogURL;
    }
}
