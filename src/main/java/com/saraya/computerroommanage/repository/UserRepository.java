package com.saraya.computerroommanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saraya.computerroommanage.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
