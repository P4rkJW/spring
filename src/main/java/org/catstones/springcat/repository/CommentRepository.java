package org.catstones.springcat.repository;

import org.catstones.springcat.entity.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * BoardRepository
 *
 * @author An Nyeong
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {
    public Iterable<Comment> findAllByBoardseq(long boardseq);
}
