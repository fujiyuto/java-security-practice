/**
 * ユーザー情報編集りクエスト
 */

package com.example.auth_api.api.dto.user.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserEditRequest {
    /**
     * ユーザー名
     */
    private String userName;
}
