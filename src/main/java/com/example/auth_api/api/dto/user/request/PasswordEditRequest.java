package com.example.auth_api.api.dto.user.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
