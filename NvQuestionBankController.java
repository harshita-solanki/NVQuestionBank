package com.nv.questionbank.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nv.questionbank.model.Questions;
import com.nv.questionbank.model.Response;
import com.nv.questionbank.service.NvQuestionBankService;
@RestController
public class NvQuestionBankController {
	Logger logger = LogManager.getLogger(NvQuestionBankController.class);
	@Autowired
	NvQuestionBankService service;
	@RequestMapping(path = "/addQuestion",method = RequestMethod.POST,produces="application/json",consumes = "application/json")
	public Response addQuestions(@RequestBody Questions questions) {
		Response response =service.addQuestion(questions);
		return response;
	}
	
	  @RequestMapping(path="/getQuestions",method=RequestMethod.GET,produces="application/json") 
	  public Response getQuestions() throws QuestionsNotFound { 
		  Response response =service.getQuestions();
		  return response;
	  }
	  @RequestMapping(path="/updateQuestion",method=RequestMethod.PUT,produces="application/json") 
	  public Response updateQuestions(@RequestBody Questions questions) throws QuestionsNotFound { 
		  Response response =service.updateQuestions(questions);
		  return response;
	  }

}
