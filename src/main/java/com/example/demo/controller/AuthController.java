package com.example.demo.controller;

import com.example.demo.dto.LoginRequestDto;
import com.example.demo.dto.SignupRequestDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // => REST API 컨트롤러. JSON 반환 기본.
@RequestMapping("/auth") // => 모든 경로 /auth 로 시작.
@RequiredArgsConstructor // => 생성자 자동 생성.
public class AuthController {

    private final UserService userService; // => UserService 주입.

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequestDto dto) {
        userService.signup(dto); // => 회원가입 처리.
        return ResponseEntity.ok("회원가입 성공");
        // => 성공 시 200 OK 와 메시지.
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto dto) {
        String token = userService.login(dto); // => 로그인 처리, 토큰 반환.
        return ResponseEntity.ok(token);
        // => 토큰을 응답 본문으로 전달.
    }
}
