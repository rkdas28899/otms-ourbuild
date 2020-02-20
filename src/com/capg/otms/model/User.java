package com.capg.otms.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.capg.otms.dao.Question;
import com.capg.otms.service.Test;
import com.capg.otms.service.TestImpl;

public interface User {
	TestImpl addTest(TestImpl test);
	TestImpl updateTest(TestImpl test);
	TestImpl deleteTest(TestImpl test);
	boolean assignTest(long userId, BigInteger TestId);
	Question addQuestions(BigInteger TestId, Question question);
	Question updateQuestions(BigInteger TestId, Question question);
	Question deleteQuestions(BigInteger TestId, Question question);
	BigDecimal getResult(TestImpl test);
}
