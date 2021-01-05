package com.nv.questionbank.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nv.questionbank.entity.Question;
@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {

//	void findByQuestions(String question);

}
