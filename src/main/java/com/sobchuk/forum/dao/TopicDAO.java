package com.sobchuk.forum.dao;

import com.sobchuk.forum.models.Theme;
import com.sobchuk.forum.models.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public interface TopicDAO extends CrudRepository<Topic, Long> {
    List<Topic> findAllByThemeId(Long Id);
    Topic findByName(String name);
}
