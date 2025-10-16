package com.spring.quiz_app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.quiz_app.entity.Question;
import com.spring.quiz_app.service.QuestionService;

@Controller
@RequestMapping("/questions")
public class QuestionController {

	QuestionService questionservice;
	QuestionController(QuestionService questionservice){
		this.questionservice = questionservice;
	}
	
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionservice.getAllQuestions();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
		return questionservice.getQuestionByCategory(category);
}
	
	@PostMapping("/add")
	public ResponseEntity<String> addQuestions(@RequestBody Question question) {
		return questionservice.addQuestions(question);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateQuestions(@RequestBody Question question) {
		return questionservice.updateQuestions(question);
	}
	
	@DeleteMapping("/delete")
	public void  deleteAll(){
		
		questionservice.deleteAll();
	}
}