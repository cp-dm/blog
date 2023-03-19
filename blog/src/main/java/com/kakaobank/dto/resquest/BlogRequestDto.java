package com.kakaobank.dto.resquest;

import com.kakaobank.enumeration.Sort;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BlogRequestDto {
    @NotEmpty
    private String query;
    private Sort sort;
    @Builder.Default
    private Integer page = 1;
    @Builder.Default
    private Integer size = 10;
}
