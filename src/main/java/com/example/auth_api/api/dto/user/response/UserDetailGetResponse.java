package com.example.auth_api.api.dto.user.response;

import com.example.auth_api.app.domain.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDetailGetResponse {
    private Long id;

    private String userName;

    private String email;

    private String role;

    public UserDetailGetResponse(User user) {
        this.id       = user.getId();
        this.userName = user.getUserName();
        this.email    = user.getEmail();
        this.role     = user.getRole();
    }
}
