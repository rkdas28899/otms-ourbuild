package com.capg.otms.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import com.capg.otms.dao.Question;

public class TestImpl implements Test{
	BigInteger testId;
	String testTitle;
	LocalTime testDuration;
	Set<Question> testQuestions;
	BigDecimal testTotalMarks;
	BigDecimal testMarksScored;
	Question currentQuestion;
	LocalDateTime startTime;
	LocalDateTime endTime;
	public TestImpl(BigInteger testId, String testTitle, LocalTime testDuration, Set<Question> testQuestions,
			BigDecimal testTotalMarks, BigDecimal testMarksScored, LocalDateTime startTime,
			LocalDateTime endTime) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		this.testQuestions = testQuestions;
		this.testTotalMarks = testTotalMarks;
		this.testMarksScored = testMarksScored;
		this.currentQuestion = currentQuestion;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public TestImpl() {
		// TODO Auto-generated constructor stub
	}
	public BigInteger getTestId() {
		return testId;
	}
	public void setTestId(BigInteger testId) {
		this.testId = testId;
	}
	public String getTestTitle() {
		return testTitle;
	}
	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}
	public LocalTime getTestDuration() {
		return testDuration;
	}
	public void setTestDuration(LocalTime testDuration) {
		this.testDuration = testDuration;
	}
	public Set<Question> getTestQuestions() {
		return testQuestions;
	}
	public void setTestQuestions(Set<Question> testQuestions) {
		this.testQuestions = testQuestions;
	}
	public BigDecimal getTestTotalMarks() {
		return testTotalMarks;
	}
	public void setTestTotalMarks(BigDecimal testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}
	public BigDecimal getTestMarksScored() {
		return testMarksScored;
	}
	public void setTestMarksScored(BigDecimal testMarksScored) {
		this.testMarksScored = testMarksScored;
	}
	public Question getCurrentQuestion() {
		return currentQuestion;
	}
	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	@Override
	public BigDecimal calculateTotalMarks() {
		// TODO Auto-generated method stub
		List<BigDecimal> big = null;
		for(Question q:this.getTestQuestions()) {
			if(q.getQuestionAnswer() == q.getChoosenAnswer()) {
				this.setTestMarksScored(q.getQuestionMarks());
			}
			else {
				this.setTestMarksScored(new BigDecimal(0));
			}
			big.add(this.getTestMarksScored());
		}
		BigDecimal sum = new BigDecimal(0);
		for(BigDecimal b:big) {
			sum = sum.add(b);
		}
		return sum;
		}
}
	
