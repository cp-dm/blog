package com.kakaobank.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BlogApiTest {
    final String PATH_BLOG = "/blog";

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("블로그 기본 파라미터 조회")
    void blog() throws Exception {
        MultiValueMap<String, String> parameter = new LinkedMultiValueMap<>();
        parameter.add("query", "kakaobank");

        mvc.perform(MockMvcRequestBuilders
                        .get("/blog")
                        .accept(MediaType.APPLICATION_JSON)
                        .params(parameter))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("블로그 기본 정확도순 조회")
    void 정확도순_정렬() throws Exception {
        MultiValueMap<String, String> parameter = new LinkedMultiValueMap<>();
        parameter.add("query", "kakaobank");
        parameter.add("sort", "accuracy");
        parameter.add("page", "3");
        parameter.add("size", "2");
        
        mvc.perform(MockMvcRequestBuilders
                        .get(PATH_BLOG)
                        .accept(MediaType.APPLICATION_JSON)
                        .params(parameter))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("블로그 기본 최신순 조회")
    void 최신순_정렬() throws Exception {
        MultiValueMap<String, String> parameter = new LinkedMultiValueMap<>();
        parameter.add("query", "kakaobank");
        parameter.add("sort", "recency");
        parameter.add("page", "4");
        parameter.add("size", "7");

        mvc.perform(MockMvcRequestBuilders
                        .get(PATH_BLOG)
                        .accept(MediaType.APPLICATION_JSON)
                        .params(parameter))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("블로그 잘못된 정렬 파라미터")
    void 정렬_잘못된값() throws Exception {
        MultiValueMap<String, String> parameter = new LinkedMultiValueMap<>();
        parameter.add("query", "kakaobank");
        parameter.add("sort", "abc");

        mvc.perform(MockMvcRequestBuilders
                        .get(PATH_BLOG)
                        .accept(MediaType.APPLICATION_JSON)
                        .params(parameter))
                .andExpect(status().is4xxClientError())
                .andDo(print());
    }

    @Test
    @DisplayName("블로그 검색 데이터 없음")
    void QUERY_잘못된값() throws Exception {
        MultiValueMap<String, String> parameter = new LinkedMultiValueMap<>();

        mvc.perform(MockMvcRequestBuilders
                        .get(PATH_BLOG)
                        .accept(MediaType.APPLICATION_JSON)
                        .params(parameter))
                .andExpect(status().is4xxClientError())
                .andDo(print());
    }

    @Test
    @DisplayName("블로그 잘못된 페이지 파라미터")
    void 페이지_잘못된값() throws Exception {
        MultiValueMap<String, String> parameter = new LinkedMultiValueMap<>();
        parameter.add("query", "kakaobank");
        parameter.add("page", "0");

        mvc.perform(MockMvcRequestBuilders
                        .get(PATH_BLOG)
                        .accept(MediaType.APPLICATION_JSON)
                        .params(parameter))
                .andExpect(status().is4xxClientError())
                .andDo(print());
    }

    @Test
    @DisplayName("카카오 블로그 잘못된 사이즈 파라미터")
    void 사이즈_잘못된값() throws Exception {
        MultiValueMap<String, String> parameter = new LinkedMultiValueMap<>();
        parameter.add("query", "kakaobank");
        parameter.add("size", "0");

        mvc.perform(MockMvcRequestBuilders
                        .get(PATH_BLOG)
                        .accept(MediaType.APPLICATION_JSON)
                        .params(parameter))
                .andExpect(status().is4xxClientError())
                .andDo(print());
    }

    @Test
    @DisplayName("인기 검색어")
    void 인기_검색어() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .get("/blog/rank")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }
}