package com.example.auth_api.api.dto.user.response;

import lombok.Data;

@Data
public class UserCreateResponse {
    /**
     * アクセストークン
     */
    private String token;
}
