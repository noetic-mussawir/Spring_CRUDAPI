package com.example.SpringDemo.repository;

import com.example.SpringDemo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Long> {
}
