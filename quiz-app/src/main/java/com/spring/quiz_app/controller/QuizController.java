package com.spring.quiz_app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.quiz_app.entity.Response;
import com.spring.quiz_app.service.QuizService;
import com.spring.quiz_app.wrapper.QuestionWrapper;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	//localhost:8080/quiz/create?category=java&numQ=5&title=JQuiz
	
	QuizService quizservice;
	QuizController(QuizService quizservice){
		this.quizservice = quizservice;
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title )
	{
		return quizservice.createQuiz(category,numQ,title);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Long id){
		return quizservice.getQuizQuestions(id);
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Long id,@RequestBody List<Response> responses) {
		return quizservice.calculateResult(id,responses);
	}
}
