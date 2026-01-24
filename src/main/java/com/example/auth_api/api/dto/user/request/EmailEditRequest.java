package com.example.auth_api.api.dto.user.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmailEditRequest {
    /**
     * 変更後のメールアドレス
     */
    private String email;
}
