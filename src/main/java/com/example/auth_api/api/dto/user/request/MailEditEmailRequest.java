package com.example.auth_api.api.dto.user.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MailEditEmailRequest {
    /**
     * 現在のメールアドレス
     */
    private String email;
}
