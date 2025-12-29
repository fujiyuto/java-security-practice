/**
 * ユーザー登録リクエストボディ
 */

package com.example.auth_api.api.dto.user.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateRequest {

    /**
     * ユーザー名
     */
    @NotBlank(message="ユーザ名を入力してください")
    @Size(min=1,max=30,message="1~30文字の範囲で入力してください")
    private String userName;

    /**
     * メールアドレス
     */
    @Email(message="正しいメールアドレス形式で入力してください")
    private String email;

    /**
     * パスワード
     */
    @NotBlank(message="パスワードを入力してください")
    private String password;

    public UserCreateRequest(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
