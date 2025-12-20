package com.example.auth_api.api.dto.user.request;

import lombok.Data;

@Data
public class PasswordEditRequest {
    /**
     * 現在のパスワード（変更前）
     */
    private String currentPassword;

    /**
     * パスワード（変更後）
     */
    private String password;
}
