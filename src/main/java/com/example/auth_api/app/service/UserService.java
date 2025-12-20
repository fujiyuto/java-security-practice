package com.example.auth_api.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.auth_api.app.domain.model.User;
import com.example.auth_api.app.domain.repository.UserRepository;
import com.example.auth_api.exception.DatabaseException;

@Service
public class UserService {
    // リポジトリクラス
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository  = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * ユーザー一覧情報取得処理
     * @param page ページ数
     * @param size 要素数
     * @return 
     */
    public Page<User> getUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> pageUser = userRepository.findAll(pageable);
        return pageUser;
    }

    /**
     * ユーザー詳細情報取得処理
     * @param id
     * @return
     * @throws RuntimeException
     */
    public User getUser(Long id) throws RuntimeException {
        // ユーザーデータ取得
        User user = userRepository.findById(id);

        return user;
    }

    /**
     * ユーザー登録処理
     * @param userName
     * @param email
     * @param password
     * @return User
     */
    public User createUser(String userName, String email, String hadhedPassword) throws DatabaseException {
        // Userドメインエンティティ定義
        User user = new User(userName, email, hadhedPassword);

        User createdUser = userRepository.save(user);

        return createdUser;
    }
}
