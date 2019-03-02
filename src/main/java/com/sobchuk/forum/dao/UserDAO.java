package com.sobchuk.forum.dao;

import com.sobchuk.forum.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface UserDAO extends CrudRepository<User, Integer> {

    public User findByName(String username);
}
