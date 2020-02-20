package com.capg.otms.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.capg.otms.dao.Question;
import com.capg.otms.service.Test;
import com.capg.otms.service.TestImpl;

public class UserImpl implements User{
	public static Map<BigInteger,TestImpl> TestsMap = new HashMap<BigInteger,TestImpl>();
	long userId;
	String userName;
	TestImpl userTest;
	boolean isAdmin;
	String userPassword;
	public UserImpl(long userId, String userName, TestImpl userTest, boolean isAdmin, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userTest = userTest;
		this.isAdmin = isAdmin;
		this.userPassword = userPassword;
	}
	public UserImpl(long UserId) {
		// TODO Auto-generated constructor stub
		this.userId = userId;
	}
	public UserImpl() {
		// TODO Auto-generated constructor stub
	}
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public TestImpl getUserTest() {
		return userTest;
	}

	public void setUserTest(TestImpl userTest) {
		this.userTest = userTest;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public TestImpl addTest(TestImpl test) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Test ID:");
		BigInteger testId = sc.nextBigInteger();
		System.out.print("Enter Test Title:");
		String testTitle = sc.next()+sc.nextLine();
		LocalTime testDuration = LocalTime.now();
		System.out.print("Enter the number of Questions:");
		int n = sc.nextInt();
		Set<Question> testQuestions = new HashSet<Question>();	
		for(int i=0; i<n; i++) {	
			Question q = new Question();
			q.questionMethod();
			testQuestions.add(q);
		}
		System.out.println("Questions Added Successfully!!");
		System.out.print("Enter test total marks:");
		BigDecimal testTotalMarks = sc.nextBigDecimal();
		System.out.print("Set Questions marks as zero:");
		//BigDecimal testMarksScored = new BigDecimal(0);
		BigDecimal testMarksScored = sc.nextBigDecimal();
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = LocalDateTime.now().plusHours(2);
		TestImpl t = new TestImpl(testId, testTitle, testDuration, testQuestions, testTotalMarks, testMarksScored, endTime, endTime);
		System.out.println("Test Added Succesfully!!!");
		return t;
	}
	@Override
	public TestImpl updateTest(TestImpl test) {
		if(test == null) {
			System.out.println("No test Available to Update");
			return null;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Test ID:");
		BigInteger testId = sc.nextBigInteger();
		System.out.print("Enter Test Title:");
		String testTitle = sc.nextLine();
		LocalTime testDuration = LocalTime.now();
		System.out.print("Enter the number of Questions:");
		int n = sc.nextInt();
		Set<Question> testQuestions = new HashSet<Question>();	
		for(int i=0; i<n; i++) {	
			Question q = new Question();
			q.questionMethod();
			testQuestions.add(q);
		}
		System.out.println("Questions Added Successfully!!");
		System.out.print("Enter test total marks:");
		BigDecimal testTotalMarks = sc.nextBigDecimal();
		System.out.println("Set Questions marks as zero:");
		BigDecimal testMarksScored = sc.nextBigDecimal();
		//BigDecimal testMarksScored = new BigDecimal(0);
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = LocalDateTime.now().plusHours(2);
		TestImpl t = new TestImpl(testId, testTitle, testDuration, testQuestions, testTotalMarks, testMarksScored, endTime, endTime);
		System.out.println("Test Update Succesfully!!!");
		return t;
	}
	@Override
	public TestImpl deleteTest(TestImpl test) {
		if(test != null) {
			System.out.println("Test deleted successfully!!!");
			test = null;
		}
		else {
			System.out.println("No test available to delete!!");
		}
		return test;
	}
	@Override
	public boolean assignTest(long userId, BigInteger TestId) {
		// TODO Auto-generated method stub
		/*String testTitle = "Computer Basics";
		LocalTime testDuration = null;
		Set<Question> testQuestions = new HashSet<Question>();
		BigDecimal testTotalMarks = new BigDecimal("10");
		BigDecimal testMarksScored = null;
		for(Question q:testQuestions) {
			testMarksScored = q.getMarksScored();
		}
		boolean currentQuestionbool = testQuestions.add(Question.questionMethod());
		Question currentQuestion = Question.questionMethod();
		LocalDateTime startTime = LocalDateTime.now();
		LocalDateTime endTime = LocalDateTime.now().plusHours(2);
		TestImpl t = new TestImpl(TestId, testTitle, testDuration, testQuestions, testMarksScored, testMarksScored, endTime, endTime);
		System.out.println("Test Assigned Successfully!!!");*/
		return true;
	}
	@Override
	public Question addQuestions(BigInteger TestId, Question question) {
		// TODO Auto-generated method stub
		Question q = null;
		q = question.questionMethod();
		return q;
	}
	@Override
	public Question updateQuestions(BigInteger TestId, Question question) {
		Question q = null;
		if(question != null) {
			q = question.questionMethod();
		}
		else {
			System.out.println("Question not available to Update!!!");
		}
		return q;
	}
	public Question deleteQuestions(BigInteger TestId, Question question) {
		question = null;
		System.out.println("Question deleted successfully!!!");
		return question;
	}
	@Override
	public BigDecimal getResult(TestImpl test) {
		Set<Question> s = test.getTestQuestions();
		List<BigDecimal> big = new ArrayList<BigDecimal>();
		for(Question q:s) {
			System.out.println(q);
		if(q.getQuestionAnswer() == q.getChoosenAnswer()) {
				q.setMarksScored(q.getQuestionMarks());
				System.out.println("If");
			}
			else {
				q.setMarksScored(new BigDecimal(0));
				System.out.println("else");
			}
			big.add(q.getMarksScored());
		}
		BigDecimal sum = new BigDecimal(0);
		for(BigDecimal b:big) {
			sum = sum.add(b);
		}
		return sum;
	}
}
