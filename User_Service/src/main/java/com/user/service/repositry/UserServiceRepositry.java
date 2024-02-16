package com.user.service.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.service.model.User;

@Repository
public interface UserServiceRepositry extends JpaRepository<User, Integer> {

}
