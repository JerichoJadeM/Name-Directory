package com.namedir.namedirectory.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.namedir.namedirectory.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Integer>{

    Optional<AppUser> findByUsername(String username);
}
