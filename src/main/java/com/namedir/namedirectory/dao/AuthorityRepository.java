package com.namedir.namedirectory.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.namedir.namedirectory.entity.Authority;
import com.namedir.namedirectory.entity.AuthorityId;

public interface AuthorityRepository extends JpaRepository<Authority, AuthorityId>{

}
