package com.kakaobank.enumeration;

import java.util.Arrays;

public enum NaverSort {
    sim(Sort.accuracy), date(Sort.recency);

    private final Sort sort;

    NaverSort(Sort sort) {
        this.sort = sort;
    }

    public static String findSort(Sort sort) {
        return Arrays.stream(values())
                .filter(v -> v.equals(sort))
                .findFirst()
                .orElse(date)
                .name();
    }
}
