package com.nv.questionbank.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.nv.questionbank.controller.QuestionsNotFound;
import com.nv.questionbank.entity.Question;
import com.nv.questionbank.model.Questions;
import com.nv.questionbank.repo.QuestionRepo;

@Component
public class NvQuestionBankDao {

	@Autowired
	QuestionRepo repo;

	public boolean addQuestion(Questions questions) {
		Question question = new Question();
		question.setId(Long.valueOf(questions.getId()));
		question.setQuestions(questions.getQuestion());
		question.setAnswer(questions.getAnswer());
		Question quest = repo.save(question);
		return true;
	}

	public List<Questions> getQuestions() throws QuestionsNotFound {
		List<Question> questionList = repo.findAll();
		List<Questions> questionsList = new ArrayList<>();
		if (!CollectionUtils.isEmpty(questionList)) {
			questionList.forEach(question -> {
				Questions questions = new Questions();
				questions.setId(question.getId().toString());
				questions.setQuestion(question.getQuestions());
				questions.setAnswer(question.getAnswer());
				questionsList.add(questions);
			});
			return questionsList;
		} else {
			throw new QuestionsNotFound("Questions are not added");
		}
	}

	public boolean updateQuestions(Questions questions) throws QuestionsNotFound {
		Optional<Question> question = repo.findById(Long.valueOf(questions.getId()));
		if (question.isPresent()) {
			question.get().setAnswer(questions.getAnswer());
			repo.save(question.get());
			return true;
		} else {
			throw new QuestionsNotFound("Question not found");
		}
	}
}
