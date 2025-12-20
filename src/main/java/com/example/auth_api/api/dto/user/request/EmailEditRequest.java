package com.example.auth_api.api.dto.user.request;

import lombok.Data;

@Data
public class EmailEditRequest {
    /**
     * 変更後のメールアドレス
     */
    private String email;
}
