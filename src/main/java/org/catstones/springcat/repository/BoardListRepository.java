package org.catstones.springcat.repository;

import org.catstones.springcat.entity.BoardList;
import org.springframework.data.repository.CrudRepository;

/**
 * BoardRepository
 *
 * @author An Nyeong
 */
public interface BoardListRepository extends CrudRepository<BoardList, Long> {
}
