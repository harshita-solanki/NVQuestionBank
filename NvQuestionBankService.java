package com.nv.questionbank.service;

import org.springframework.stereotype.Component;

import com.nv.questionbank.controller.QuestionsNotFound;
import com.nv.questionbank.model.Questions;
import com.nv.questionbank.model.Response;
@Component
public interface NvQuestionBankService {
	public Response addQuestion(Questions questions);

	public Response updateQuestions(Questions questions) throws QuestionsNotFound;

	public Response getQuestions() throws QuestionsNotFound;

}
