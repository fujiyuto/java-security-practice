package com.example.auth_api.api.dto.common;

import lombok.Data;

@Data
public class ErrorResponse {

    /**
     * エラー時のステータスコード
     */
    private int status;

    /**
     * エラーメッセージ
     */
    private String message;
}
