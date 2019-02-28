package com.sobchuk.forum.topic;

import org.springframework.data.repository.CrudRepository;

public abstract class TopicDAO implements CrudRepository<Topic, Integer> {
}
