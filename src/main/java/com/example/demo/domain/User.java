package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // => PK.

    @Column(unique = true)
    private String username; // => 유니크 제약.

    private String password; // => 해시된 비번.

    private String role = "USER"; // => 기본 "USER". 필요 시 ADMIN 추가.
}
