package com.example.auth_api.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth_api.api.dto.user.request.EmailEditRequest;
import com.example.auth_api.api.dto.user.request.MailEditEmailRequest;
import com.example.auth_api.api.dto.user.request.PasswordEditRequest;
import com.example.auth_api.api.dto.user.request.UserCreateRequest;
import com.example.auth_api.api.dto.user.request.UserEditRequest;
import com.example.auth_api.api.dto.user.response.UserDetailGetResponse;
import com.example.auth_api.api.dto.user.response.UserListGetResponse;
import com.example.auth_api.app.domain.model.User;
import com.example.auth_api.app.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    // サービスクラス
    private final UserService userService;

    // パスワードエンコーダー
    private final PasswordEncoder passwordEncoder;
    
    @GetMapping(value="/users", produces="application/json")
    public ResponseEntity<Page<UserListGetResponse>> getUsers(
        @RequestParam(defaultValue="1") int page, 
        @RequestParam(defaultValue="10") int size
    ) {
        Page<User> result = userService.getUsers(page, size);
        Page<UserListGetResponse> response = result.map(UserListGetResponse::new);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value="/users/{userId}", produces="application/json")
    public ResponseEntity<UserDetailGetResponse> getUser(@PathVariable Long userId) {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(new UserDetailGetResponse(user));
    }

    @PostMapping(value="/users")
    public ResponseEntity<String> registerUser(@RequestBody UserCreateRequest request) {
        User result = userService.createUser(request.getUserName(), request.getEmail(), this.passwordEncoder.encode(request.getPassword()));

        return ResponseEntity.status(HttpStatus.CREATED).body()
    }

    @PatchMapping(value="/users/{userId}")
    public String editUser(@PathVariable Long userId, @RequestBody UserEditRequest request) {
        return "";
    }

    @DeleteMapping(value="/users")
    public String deleteUser(@PathVariable Long userId) {
        return "";
    }

    @PatchMapping(value="/users/password")
    public String editPassowrd(@RequestBody PasswordEditRequest request) {
        return "";
    }

    @PatchMapping(value="/users/email")
    public String sendMailEditEmail(@RequestBody MailEditEmailRequest request) {
        // TODO: メールアドレス変更フォームメール送信
        return "";
    }

    @PatchMapping(value="/users/email/verify")
    public String editEmail(@RequestParam String token, @RequestBody EmailEditRequest request) {
        return "";
    }
}
