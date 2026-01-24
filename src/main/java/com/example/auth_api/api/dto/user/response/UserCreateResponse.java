package com.example.auth_api.api.dto.user.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserCreateResponse {
    /**
     * アクセストークン
     */
    private final String token;
}
