package com.spring.quiz_app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.quiz_app.wrapper.QuestionWrapper;
import com.spring.quiz_app.entity.Question;
import com.spring.quiz_app.entity.Quiz;
import com.spring.quiz_app.entity.Response;
import com.spring.quiz_app.repo.QuestionRepo;
import com.spring.quiz_app.repo.QuizRepo;

@Service
public class QuizService {

	QuizRepo quizrepo;
	QuestionRepo questionrepo;
	QuizService(QuizRepo quizrepo,QuestionRepo questionrepo){
		this.quizrepo = quizrepo;
		this.questionrepo = questionrepo;
	}
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		
		List<Question> question = questionrepo.findRandomQuestionByCategory(category,numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(question);
		quizrepo.save(quiz);
		
		return new ResponseEntity<>("Success",HttpStatus.OK);
		
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Long id) {
	
		Optional<Quiz> quiz = quizrepo.findById(id);
		List<Question> questionFromDB = quiz.get().getQuestions();
		List<com.spring.quiz_app.wrapper.QuestionWrapper> questionsForUser = new ArrayList<>();
		for(Question q : questionFromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			questionsForUser.add(qw);
		}
		
		
		return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Long id, List<Response> responses) {
		
		Quiz quiz = quizrepo.findById(id).get();
		List<Question> questions = quiz.getQuestions();
		int right = 0;
		int i = 0;
		for(Response response : responses) {
			if(response.getResponse().equals(questions.get(i).getRightAnswer())) {
				right++;
				
			
			}
			
			i++;
		}
		return new ResponseEntity<>(right,HttpStatus.OK);
	}

	

}
