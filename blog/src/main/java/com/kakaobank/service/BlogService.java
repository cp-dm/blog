package com.kakaobank.service;

import com.kakaobank.dto.response.BlogDocumentsResponseDto;
import com.kakaobank.dto.response.BlogResponseDto;
import com.kakaobank.dto.resquest.BlogRequestDto;
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

@RequiredArgsConstructor
@Service
@Slf4j
public class BlogService {
    @Value("${api.kakaobank.url}")
    String url;

    @Value("${api.kakaobank.api-key}")
    String API_KEY;
    private final RestTemplate restTemplate;
    private final BlogNaverService blogNaverService;
    private final BlogRankService blogRankService;

    public Page<BlogDocumentsResponseDto> blog(BlogRequestDto blogRequestDto) {
        Page<BlogDocumentsResponseDto> responseSearchBlog;

        try {
            String searchBlogURL = getUrl(blogRequestDto);
            HttpEntity<Void> requestEntity = getHeader();

            ResponseEntity<BlogResponseDto> blogResponseDtoResponseEntity = restTemplate.exchange(searchBlogURL, HttpMethod.GET, requestEntity, BlogResponseDto.class);
            if (isNotSuccess(blogResponseDtoResponseEntity.getStatusCode())) {
                log.error("kakao api error responseBody " + blogResponseDtoResponseEntity.getBody());
                throw new RuntimeException("kakao api error");
            }

            BlogResponseDto BlogResponseDto = blogResponseDtoResponseEntity.getBody();

            Pageable pageable = PageRequest.of(blogRequestDto.getPage(), blogRequestDto.getSize());

            responseSearchBlog = new PageImpl<>(BlogResponseDto.getDocuments(), pageable, BlogResponseDto.getMeta().getTotalCount());

        } catch (Exception e) {
            responseSearchBlog = blogNaverService.blog(blogRequestDto);
        }

        blogRankService.saveRank(blogRequestDto.getQuery());

        return responseSearchBlog;
    }

    private boolean isNotSuccess(HttpStatus statusCode) {
        return !statusCode.is2xxSuccessful();
    }

    private HttpEntity<Void> getHeader() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Authorization", "KakaoAK " + API_KEY);

        return new HttpEntity<>(httpHeaders);
    }

    private String getUrl(BlogRequestDto blogRequestDto) {
        final String BLOG_PATH = "blog";
        String blogURL = url + BLOG_PATH + "?query=" + URLUtil.encodeUTF8(blogRequestDto.getQuery());

        URLUtil.urlSettingParameter(url, "sort", blogRequestDto.getSort());
        URLUtil.urlSettingParameter(url, "page", blogRequestDto.getPage());
        URLUtil.urlSettingParameter(url, "size", blogRequestDto.getSize());
        return blogURL;
    }
}
