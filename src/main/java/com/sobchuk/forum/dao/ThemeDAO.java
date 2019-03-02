package com.sobchuk.forum.dao;

import com.sobchuk.forum.models.Theme;
import org.springframework.data.repository.CrudRepository;

public interface ThemeDAO extends CrudRepository<Theme, Long> {
}
