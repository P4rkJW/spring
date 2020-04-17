package org.catstones.springcat.repository;

import java.util.Optional;

import org.catstones.springcat.entity.Post;
import org.springframework.data.repository.CrudRepository;

/**
 * BoardRepository
 *
 * @author An Nyeong
 */
public interface PostRepository extends CrudRepository<Post, String> {
    public Iterable<Post> findAllByAuthorSeq(String authorSeq);
}
