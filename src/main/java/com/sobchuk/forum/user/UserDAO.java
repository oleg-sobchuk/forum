package com.sobchuk.forum.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public abstract class UserDAO implements CrudRepository<User, Integer> {
}
