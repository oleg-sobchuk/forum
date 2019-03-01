package com.sobchuk.forum.dao;


import com.sobchuk.forum.models.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CommentDAO extends CrudRepository<Comment, Long>{

}
