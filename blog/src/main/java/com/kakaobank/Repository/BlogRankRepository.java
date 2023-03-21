package com.kakaobank.Repository;

import com.kakaobank.entity.BlogRank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRankRepository extends JpaRepository<BlogRank, String> {
    List<BlogRank> findTop10ByOrderByHitDesc();
}
