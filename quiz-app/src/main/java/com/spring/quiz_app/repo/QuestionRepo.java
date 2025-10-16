package com.spring.quiz_app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.quiz_app.entity.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {

	List<Question> findByCategory(String category);

	@Query(value="SELECT * FROM questions q where q.category=:category ORDER BY RAND() LIMIT :numQ",nativeQuery=true)
	List<Question> findRandomQuestionByCategory(@Param("category")String category,@Param("numQ") int numQ);
}
