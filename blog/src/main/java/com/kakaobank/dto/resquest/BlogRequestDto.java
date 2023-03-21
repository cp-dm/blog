package com.kakaobank.dto.resquest;

import com.kakaobank.enumeration.Sort;
import lombok.*;

import javax.validation.constraints.Min;
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
    @Min(1)
    private Integer page = 1;
    @Builder.Default
    @Min(1)
    private Integer size = 10;
}
