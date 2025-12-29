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

    private User (
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

    private User(
        String userName,
        String email,
        String password
    ) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(
        Long id,
        String userName
    ) {
        this.id = id;
        this.userName = userName;
    }

    /**
     * リポジトリでDBから取得したデータを格納する時に使用
     * @param id
     * @param userName
     * @param email
     * @param password
     * @param role
     * @return
     */
    public static User createUser(
        Long id,
        String userName,
        String email,
        String password,
        String role
    ) {
        return new User(id, userName, email, password, role);
    }

    /**
     * ユーザー登録リクエスト時に使用
     * @param userName
     * @param email
     * @param password
     * @return
     */
    public static User createRegisterRequestUser(
        String userName,
        String email,
        String password
    ) {
        return new User(userName, email, password);
    }

    /**
     * フィールドのuserNameとemailを更新
     * @param userName
     * @param email
     */
    public void updateProfile(String userName, String email) {
        if ( userName != null ) {
            this.userName = userName;
        }

        if ( email != null ) {
            this.email = email;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        // Userクラスではない場合false
        if (obj instanceof User == false) {
            return false;
        }

        User receivedUser = (User)obj;
        if (receivedUser.id == this.id && receivedUser.userName == this.userName && receivedUser.email == this.email) {
            return true;
        } else {
            return false;
        }
    }
}
