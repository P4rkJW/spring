package org.catstones.springcat;

import org.springframework.data.repository.CrudRepository;

/**
 * BoardRepository
 *
 * @author An Nyeong
 */
public interface PostRepository extends CrudRepository<Post, Long> {
}
