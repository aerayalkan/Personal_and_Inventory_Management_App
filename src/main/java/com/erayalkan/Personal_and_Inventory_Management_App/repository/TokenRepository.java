package com.erayalkan.Personal_and_Inventory_Management_App.repository;

import com.erayalkan.Personal_and_Inventory_Management_App.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

    @Query("SELECT t FROM Token t INNER JOIN Personal p ON t.user.id = p.id WHERE t.user.id = :userId AND t.loggedOut = false")
    List<Token> findAllAccessTokensByUser(Long userId);

    Optional<Token> findByAccessToken(String token);

    Optional<Token> findByRefreshToken(String token);
}
