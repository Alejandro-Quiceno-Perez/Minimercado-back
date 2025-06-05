package com.POS.minimercados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.POS.minimercados.entity.User;

public interface UserRepository extends JpaRepository <User, Long> {

}
