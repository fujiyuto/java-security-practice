package com.example.auth_api.api.dto.user.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCreateResponse {
    /**
     * アクセストークン
     */
    private final String token;
}
