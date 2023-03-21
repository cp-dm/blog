package com.kakaobank.controller;

import com.kakaobank.dto.response.BlogRankResponseDto;
import com.kakaobank.service.BlogRankService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogRankController {
    private final BlogRankService blogRankService;

    @GetMapping("/blog/rank")
    public List<BlogRankResponseDto> blogRank() {
        return blogRankService.rank();
    }
}
