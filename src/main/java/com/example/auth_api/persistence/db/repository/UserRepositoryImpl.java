package com.example.auth_api.persistence.db.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.auth_api.app.domain.model.User;
import com.example.auth_api.app.domain.repository.UserRepository;
import com.example.auth_api.exception.NotFoundException;
import com.example.auth_api.persistence.db.entity.UserEntity;
import com.example.auth_api.persistence.db.jpa.JpaUserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    // JpaRepository
    private final JpaUserRepository jpaRepo;

    public UserRepositoryImpl(JpaUserRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        Page<UserEntity> queryResult = this.jpaRepo.findAll(pageable);
        return queryResult.map(user -> this.toDomainEntity(user));
    }

    @Override
    public User findById(Long id) {
        // クエリ結果取得
        Optional<UserEntity> queryResult = this.jpaRepo.findById(id);

        // データ取得
        // データがなかった場合はNotFoundエラー
        UserEntity dbEntity = queryResult.orElseThrow(() -> new NotFoundException("User data not found."));

        return this.toDomainEntity(dbEntity);
    }

    @Override
    public User save(User user) {
        // 登録処理
        UserEntity queryResult = this.jpaRepo.save(this.toDbEntity(user));

        
        if ( queryResult == null ) {
            throw new RuntimeException("Can't create user data.");
        }

        // 作成ユーザーデータ返却
        return this.toDomainEntity(queryResult);
    }

    private User toDomainEntity(UserEntity dbEntity) {
        return new User(dbEntity.getId(), dbEntity.getUserName(), dbEntity.getEmail(), dbEntity.getPassword(), dbEntity.getRole());
    }

    private UserEntity toDbEntity(User user) {
        UserEntity dbEntity = new UserEntity();
        dbEntity.setId(user.getId());
        dbEntity.setUserName(user.getUserName());
        dbEntity.setEmail(user.getEmail());
        dbEntity.setPassword(user.getPassword());
        dbEntity.setRole(user.getRole());

        return dbEntity;
    }

}
