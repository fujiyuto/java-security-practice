/**
 * ユーザー情報編集りクエスト
 */

package com.example.auth_api.api.dto.user.request;

import lombok.Data;

@Data
public class UserEditRequest {
    /**
     * ユーザー名
     */
    private String userName;
}
