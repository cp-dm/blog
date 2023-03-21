package com.kakaobank.controller;

import com.kakaobank.dto.response.BlogDocumentsResponseDto;
import com.kakaobank.dto.resquest.BlogRequestDto;
import com.kakaobank.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;

    @GetMapping("/blog")
    public Page<BlogDocumentsResponseDto> blog(@Valid BlogRequestDto blogRequestDto) {
        Page<BlogDocumentsResponseDto> blogDocumentsResponseDtoList = blogService.blog(blogRequestDto);
        return blogDocumentsResponseDtoList;
    }
}
