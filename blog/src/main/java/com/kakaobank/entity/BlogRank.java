package com.kakaobank.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "blog_rank")
public class BlogRank {
    @Id
    private String keyword;
    @Builder.Default
    private int hit = 0;

    public static BlogRank of(String keyword) {
        return BlogRank.builder().keyword(keyword).build();
    }

    public BlogRank updateHit() {
        this.hit++;
        return this;
    }
}
