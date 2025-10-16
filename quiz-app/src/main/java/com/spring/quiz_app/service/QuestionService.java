package com.spring.quiz_app.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.quiz_app.entity.Question;
import com.spring.quiz_app.repo.QuestionRepo;

@Service
public class QuestionService {

	QuestionRepo questionrepo;
	QuestionService(QuestionRepo questionrepo){
		this.questionrepo = questionrepo;
	}
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
		return new ResponseEntity<>(questionrepo.findAll(),HttpStatus.OK);
	}
		catch(Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(questionrepo.findAll(),HttpStatus.BAD_REQUEST);
		
	}
	
	
	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		
		try {
		return new ResponseEntity<>(questionrepo.findByCategory(category),HttpStatus.OK);
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(questionrepo.findByCategory(category),HttpStatus.BAD_REQUEST);
	}
	

	public ResponseEntity<String> addQuestions(Question question) {
		
		questionrepo.save(question);
		
	 try {	return new ResponseEntity<>("success",HttpStatus.CREATED);
	}
	
	 catch(Exception e) {
		 e.printStackTrace();
	 }
	 
	 return new ResponseEntity<>("Failure",HttpStatus.BAD_REQUEST);
	

}

	public ResponseEntity<String> updateQuestions(Question question) {
		
		questionrepo.save(question);
		
		try {
		return new ResponseEntity<>("Updated",HttpStatus.CREATED);
	}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return new ResponseEntity<>("Not updated",HttpStatus.BAD_REQUEST);
}

	public void deleteAll() {
		
		questionrepo.deleteAll();
		
	}
	
}
