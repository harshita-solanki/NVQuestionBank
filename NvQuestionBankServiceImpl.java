package com.nv.questionbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.questionbank.controller.QuestionsNotFound;
import com.nv.questionbank.dao.NvQuestionBankDao;
import com.nv.questionbank.model.Questions;
import com.nv.questionbank.model.Response;
import com.nv.questionbank.model.ResponseData;
@Service
public class NvQuestionBankServiceImpl implements NvQuestionBankService {
	@Autowired
	NvQuestionBankDao nvQuestionBankDao;

	@Override
	public Response addQuestion(Questions questions) {
		boolean added = nvQuestionBankDao.addQuestion(questions);
		Response response = null;
		if (added) {
			response = new Response();
			response.setResponseStatus("Success");
			response.setResponseCode(0);
			response.setMessage("questions added successfully");
			response.setData(null);
			return response;
		}else {
			
		}
		return response;
	}

	@Override
	public Response updateQuestions(Questions questions) throws QuestionsNotFound {
	boolean b=	nvQuestionBankDao.updateQuestions(questions);
	Response response = null;
	if (b) {
		response = new Response();
		response.setResponseStatus("Success");
		response.setResponseCode(0);
		response.setMessage("questions updated successfully");
		response.setData(null);
		return response;
	}
	return response;
	}

	@Override
	public Response getQuestions() throws QuestionsNotFound {
		List<Questions> questions  = nvQuestionBankDao.getQuestions();
		Response response = null;
		if (!questions.isEmpty()) {
			response = new Response();
			response.setResponseStatus("Success");
			response.setResponseCode(0);
			ResponseData data=new ResponseData();
			data.setQuestionList(questions);
			response.setData(data);
			return response;
		}		return response;
	}

}
