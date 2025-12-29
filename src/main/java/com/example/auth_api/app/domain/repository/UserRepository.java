package com.example.auth_api.app.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.example.auth_api.app.domain.model.User;

public interface UserRepository {
    // ユーザー一覧返却処理
    Page<User> findAll(Pageable pageable);

    // IDに一致するユーザー取得
    User findById(Long id);

    // ユーザ名に一致するユーザー取得
    User findByUserName(String userName);

    // ユーザー作成
    User save(User user);

    // ユーザー削除
    boolean delete(Long id);
}
