package com.nv.questionbank.model;

public class Questions {
	private String id;
 private String question;
 
 private String answer;

public String getQuestion() {
	return question;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public void setQuestion(String question) {
	this.question = question;
}

public String getAnswer() {
	return answer;
}

public void setAnswer(String answer) {
	this.answer = answer;
}
 
}
