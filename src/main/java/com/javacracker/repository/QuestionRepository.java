package com.javacracker.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.javacracker.entity.Question;

public interface QuestionRepository extends PagingAndSortingRepository<Question, Long> {

    @Query("SELECT q FROM Question q WHERE "
         + "(:company IS NULL OR q.company LIKE %:company%) AND "
         + "(:difficulty IS NULL OR q.difficulty = :difficulty)")
    Page<Question> filterQuestions(
        @Param("company") String company,
        @Param("difficulty") String difficulty,
        Pageable pageable
    );

    long countByDifficulty(String difficulty);
    @Query("SELECT COUNT(q) FROM Question q")
    long getTotalCount();

}
