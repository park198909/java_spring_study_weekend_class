package org.koreait.repositories;

import org.koreait.entities.BoardData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardDataRepository extends JpaRepository<BoardData, Long>,
        QuerydslPredicateExecutor<BoardData> {
    List<BoardData> findByBoardId(String boardId);

    @Query("SELECT b FROM BoardData b LEFT JOIN FETCH b.user WHERE b.boardId=:id")
    List<BoardData> getBoardDatas(@Param("id") String boardId);
}
