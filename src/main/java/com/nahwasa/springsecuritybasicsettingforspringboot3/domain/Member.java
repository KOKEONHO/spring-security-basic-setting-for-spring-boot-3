package com.nahwasa.springsecuritybasicsettingforspringboot3.domain;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(unique = true)
    private String email;

    private String password;

    private String roles;

    private Member(Long memberId, String email, String password, String roleUser) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.roles = roleUser;
    }

    protected Member() {}

    public static Member createUser(String email, String password) {
        return new Member(null, email, password, "USER");
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRoles() {
        return roles;
    }
}
