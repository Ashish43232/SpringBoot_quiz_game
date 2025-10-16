package com.spring.quiz_app.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.quiz_app.entity.Quiz;



public interface QuizRepo extends JpaRepository<Quiz, Long> {


}
