/**
 * ユーザー登録リクエストボディ
 */

package com.example.auth_api.api.dto.user.request;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.auth_api.app.domain.model.User;

import lombok.Data;

@Data
public class UserCreateRequest {
    /**
     * ユーザー名
     */
    private String userName;

    /**
     * メールアドレス
     */
    private String email;

    /**
     * パスワード
     */
    private String password;

    public UserEntity toEntity(PasswordEncoder passwordEncoder) {
        return UserEntity.builder()
                   .userName(this.userName)
                   .email(this.email)
                   .password(passwordEncoder.encode(this.password))
                   .build();
    }
}
