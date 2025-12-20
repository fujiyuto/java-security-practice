package com.example.auth_api.persistence.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
public class UserEntity {

    /**
     * 主キー
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    /**
     * ユーザー名
     */
    @Column(name="username", nullable=false, length=30, unique=true)
    private String userName;

    /**
     * メールアドレス
     */
    @Column(name="email", nullable=false, unique=true)
    private String email;

    /**
     * パスワード
     */
    @Column(name="password", nullable=false, length=64)
    private String password;

    /**
     * ロール（役職）
     */
    @Column(name="role", nullable=false)
    private String role;
}
