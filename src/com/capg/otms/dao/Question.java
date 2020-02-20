package com.capg.otms.dao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question {
	BigInteger questionId;
	List<String> questionOptions;
	String questionTitle;
	int questionAnswer;
	BigDecimal questionMarks;
	int choosenAnswer;
	BigDecimal marksScored;
	public Question(BigInteger questionId, List<String> questionOptions, String questionTitle, int questionAnswer,
			BigDecimal questionMarks, int choosenAnswer, BigDecimal marksScored) {
		super();
		this.questionId = questionId;
		this.questionOptions = questionOptions;
		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
		this.choosenAnswer = choosenAnswer;
		this.marksScored = marksScored;
	}
	public Question() {
		// TODO Auto-generated constructor stub
	}
	public BigInteger getQuestionId() {
		return questionId;
	}
	public void setQuestionId(BigInteger questionId) {
		this.questionId = questionId;
	}
	public List<String> getQuestionOptions() {
		return questionOptions;
	}
	public void setQuestionOptions(List<String> questionOptions) {
		this.questionOptions = questionOptions;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public int getQuestionAnswer() {
		return questionAnswer;
	}
	public void setQuestionAnswer(int questionAnswer) {
		this.questionAnswer = questionAnswer;
	}
	public BigDecimal getQuestionMarks() {
		return questionMarks;
	}
	public void setQuestionMarks(BigDecimal questionMarks) {
		this.questionMarks = questionMarks;
	}
	public int getChoosenAnswer() {
		return choosenAnswer;
	}
	public void setChoosenAnswer(int choosenAnswer) {
		this.choosenAnswer = choosenAnswer;
	}
	public BigDecimal getMarksScored() {
		return marksScored;
	}
	public void setMarksScored(BigDecimal marksScored) {
		this.marksScored = marksScored;
	}
	public static Question questionMethod() {
		//if(i == 1) {
			Scanner sc = new Scanner(System.in);
			Question q1 = new Question();
			System.out.print("Enter Question Title:");
			String qTitle = sc.next()+sc.nextLine();
			q1.setQuestionTitle(qTitle);
			List<String> ls = new ArrayList<String>();
			System.out.println("Enter options:");
			for(int  i=0; i<4; i++) {
				String s = sc.nextLine();
				ls.add(s);
			}
			q1.setQuestionOptions(ls);
			System.out.print("Enter Question id:");
			BigInteger qId = sc.nextBigInteger();
			q1.setQuestionId(qId);
			System.out.print("Enter the Key:");
			int qKey = sc.nextInt();
			q1.setQuestionAnswer(qKey);
			//System.out.println(q1.getQuestionAnswer());
			System.out.println("Emter marks for the Question");
			BigDecimal qMarks = sc.nextBigDecimal();
			q1.setQuestionMarks(qMarks);
			return q1;
	}
}
