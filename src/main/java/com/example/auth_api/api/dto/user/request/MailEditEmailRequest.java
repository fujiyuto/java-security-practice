package com.example.auth_api.api.dto.user.request;

import lombok.Data;

@Data
public class MailEditEmailRequest {
    /**
     * 現在のメールアドレス
     */
    private String email;
}
