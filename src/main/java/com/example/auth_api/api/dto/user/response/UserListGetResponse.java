package com.example.auth_api.api.dto.user.response;

import com.example.auth_api.app.domain.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserListGetResponse {
    /**
     * id
     */
    private Long id;

    /**
     * ユーザー名
     */
    private String userName;

    public UserListGetResponse(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
    }
}

