package com.kakaobank.service;

import com.kakaobank.Repository.BlogRankRepository;
import com.kakaobank.dto.response.BlogRankResponseDto;
import com.kakaobank.entity.BlogRank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class BlogRankService {
    final String BLOG_RANK_KEY = "blogRank";
    private final RedisTemplate<String, String> redisTemplate;
    private final BlogRankRepository blogRankRepository;

    public void saveRank(String keyword) {
        try {
            redisTemplate.opsForZSet().incrementScore(BLOG_RANK_KEY, keyword,1);
            saveDB(keyword);
        } catch (Exception e) {
            log.error("saveRank Error keyword : {}", keyword, e);
        }
    }

    private void saveDB(String keyword) {
        try {
            BlogRank blogRank = blogRankRepository.findById(keyword).orElse(BlogRank.of(keyword)).updateHit();
            blogRankRepository.save(blogRank);
        } catch (Exception e) {
            log.error("saveDB Error keyword : {}", keyword);
        }
    }

    public List<BlogRankResponseDto> rank() {
        try {
            Set<ZSetOperations.TypedTuple<String>> typedTuples = redisTemplate.opsForZSet().reverseRangeWithScores(BLOG_RANK_KEY, 0, 9);
            return typedTuples.stream()
                    .map(BlogRankResponseDto::of)
                    .collect(toList());
        } catch (Exception e) {
            List<BlogRank> blogRankList = blogRankRepository.findTop10ByOrderByHitDesc();
            return blogRankList.stream()
                    .map(blogRank -> BlogRankResponseDto.convert(blogRank.getKeyword(), blogRank.getHit()))
                    .collect(toList());
        }
    }
}
