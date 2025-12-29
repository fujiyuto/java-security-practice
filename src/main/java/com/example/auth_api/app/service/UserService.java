package com.example.auth_api.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository  = userRepository;
    }

    /**
     * ユーザー一覧情報取得処理
     * @param page ページ数
     * @param size 要素数
     * @return 
     */
    public Page<User> getUsers(int page, int size) {
        logger.info("ユーザー一覧取得処理");
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
        logger.info("ユーザー詳細取得処理: id={}", id);
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
        logger.info("ユーザー登録処理: username={}, email={}", userName, email);
        // Userドメインエンティティ定義
        User user = User.createRegisterRequestUser(userName, email, hadhedPassword);

        User createdUser = userRepository.save(user);

        return createdUser;
    }

    public User editUser(Long id, String userName) {
        // ユーザ取得
        User user = userRepository.findById(id);

        // 取得したユーザのユーザ名更新
        user.updateProfile(userName, null);

        User updatedUser = userRepository.save(user);

        return updatedUser;
    }
}
