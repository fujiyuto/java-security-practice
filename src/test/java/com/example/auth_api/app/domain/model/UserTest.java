package com.example.auth_api.app.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    void ユーザーが作成される_1() {
        User user = User.createUser(1L, "test", "test@gmail.com", "password", "USER");

        assertNotNull(user);
        assertEquals(1L, user.getId());
    }

    @Test
    void ユーザーが作成される_2() {
        User user = User.createRegisterRequestUser("test", "test@gmail.com", "password");

        assertNotNull(user);
        assertEquals(null, user.getId());
        assertEquals("test", user.getUserName());
    }

    @Test
    void ユーザー名とパスワードの更新() {
        // 変更前の値
        String beforeUserName = "before_username";
        String beforeEmail = "before.email@gmail.com";

        // 変更後の値
        String afterUserName = "after_username";
        String afterEmail = "after.email@gmail.com";

        User beforeUpdatedUser = User.createUser(1L, beforeUserName, beforeEmail, "password", "USER");

        beforeUpdatedUser.updateProfile(afterUserName, afterEmail);

        assertEquals("after_username", afterUserName);
        assertEquals("after.email@gmail.com", afterEmail);
    }
}
