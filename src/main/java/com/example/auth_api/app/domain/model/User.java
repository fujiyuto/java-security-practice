package com.example.auth_api.app.domain.model;

import lombok.Getter;

@Getter
public class User {
    /**
     * ID
     */
    private Long id;

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

    /**
     * ロール
     */
    private String role = "USER";

    public User (
        Long id,
        String userName,
        String email,
        String password,
        String role
    ) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(
        String userName,
        String email,
        String password
    ) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
