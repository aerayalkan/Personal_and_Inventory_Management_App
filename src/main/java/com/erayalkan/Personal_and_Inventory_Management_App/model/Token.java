package com.erayalkan.Personal_and_Inventory_Management_App.model;

import jakarta.persistence.*;

@Entity
@Table(name= "token")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "is_logged_out")
    private boolean loggedOut;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Personal user;


    public Token() {}


    public Token(Long id, String accessToken, String refreshToken, boolean loggedOut, Personal user) {
        this.id = id;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.loggedOut = loggedOut;
        this.user = user;
    }

    // Getter and setter methods
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public boolean isLoggedOut() {
        return loggedOut;
    }

    public void setLoggedOut(boolean loggedOut) {
        this.loggedOut = loggedOut;
    }

    public Personal getUser() {
        return user;
    }

    public void setUser(Personal user) {
        this.user = user;
    }
}
