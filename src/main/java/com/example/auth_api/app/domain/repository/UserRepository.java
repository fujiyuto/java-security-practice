package com.example.auth_api.app.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.auth_api.app.domain.model.User;

public interface UserRepository {
    // ユーザー一覧返却処理
    Page<User> findAll(Pageable pageable);

    // IDに一致するユーザー返却処理
    User findById(Long id);

    // ユーザー作成
    User save(User user);

    // ユーザー編集
    User edit(User user);

    // ユーザー削除
    boolean delete(Long id);


}
