package com.example.auth_api.api.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.auth_api.api.dto.user.response.UserListGetResponse;
import com.example.auth_api.app.domain.model.User;
import com.example.auth_api.app.service.UserService;
import com.example.auth_api.config.SecurityConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = UserController.class)
@Import(SecurityConfig.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private UserService userService;

    @MockitoBean
    private PasswordEncoder passwordEncoder;

    @Test
    void ユーザー一覧取得処理_200レスポンス() throws Exception {
        // テスト用のデータ
        List<User> userList = List.of(
            User.createUser(4L, "test4", "test4@gmail.com", "password", "USER"),
            User.createUser(5L, "test5", "test5@gmail.com", "password", "USER")
        );

        // 2ページ目、ページ内要素数3を想定
        Pageable pageable = PageRequest.of(1, 3);

        // DBレコード総数5件を想定
        Page<User> userPage = new PageImpl<>(userList, pageable, 5);

        // contentパラメータ内のレコード総数をレスポンスの形式に変換
        userPage.map(UserListGetResponse::new);

        given(userService.getUsers(1, 3)).willReturn(userPage);
        
        // レスポンス結果に対して何かしら処理が必要な際に使用
        mockMvc.perform(get("/api/users")
                    .param("page", "1")
                    .param("size", "3"))
                .andExpectAll(
                    status().isOk(),
                    content().contentType(MediaType.APPLICATION_JSON),
                    jsonPath("$.content[0].id").value(4),
                    jsonPath("$.content[0].userName").value("test4"),
                    jsonPath("$.totalElements").value(5),
                    jsonPath("$.totalPages").value(2),
                    jsonPath("$.number").value(1),
                    jsonPath("$.numberOfElements").value(2),
                    jsonPath("$.first").value(false),
                    jsonPath("$.last").value(true)
                );

    }

    @Test
    void ユーザー詳細取得処理_200レスポンス() throws Exception {
        // 取得したいユーザーのID
        long getUserId = 1L;

        // テスト用データ
        User testUser = User.createUser(getUserId, "test1", "test1@gmail.com", "password", "USER");

        given(userService.getUser(getUserId)).willReturn(testUser);

        mockMvc.perform(get("/api/users/{userId}", 1))
                .andExpectAll(
                    status().isOk(),
                    content().contentType(MediaType.APPLICATION_JSON),
                    jsonPath("$.id").value(1),
                    jsonPath("$.userName").value("test1"),
                    jsonPath("$.email").value("test1@gmail.com"),
                    jsonPath("$.role").value("USER")
                );
    }

    // @Test
    // void ユーザー作成処理_201レスポンス() throws Exception {
    //     UserCreateRequest request = new UserCreateRequest("test", "test@gmail.com", "password");
    // }
}
