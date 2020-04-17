package org.catstones.springcat.repository;

import java.util.List;
import org.catstones.springcat.entity.ReplyComment;
import org.springframework.data.repository.CrudRepository;

/**
 * BoardRepository
 *
 * @author An Nyeong
 * @param <T>
 */
public interface ReplyCommentRepository<T> extends CrudRepository<ReplyComment, Long> {
    // public ReplyComment findTop5ByOrderBySeqAsc();
    public Iterable<ReplyComment> findAllByOrderBySeqDesc();

    public Iterable<ReplyComment> findTop5ByOrderBySeqAsc();
}