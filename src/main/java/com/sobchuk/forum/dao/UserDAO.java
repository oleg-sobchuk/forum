package com.sobchuk.forum.dao;

import com.sobchuk.forum.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface UserDAO extends CrudRepository<User, Integer> {

    public User findByName(String username);
    public User findByEmail(String email);
}
