package com.capg.otms.ui;

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

import javax.sound.midi.SysexMessage;

import com.capg.otms.dao.Question;
import com.capg.otms.misc.InvalidName;
import com.capg.otms.misc.InvalidPassword;
import com.capg.otms.model.UserImpl;
import com.capg.otms.service.Test;
import com.capg.otms.service.TestImpl;

public class OtmsImpl {
	static Scanner sc= new Scanner(System.in);
	public static List<UserImpl> lu = new ArrayList<UserImpl>();
	public static List<TestImpl> lt = new ArrayList<TestImpl>();
	public static List<Question> lq = new ArrayList<Question>();
	public static Map<BigInteger,TestImpl> TestsMap = new HashMap<BigInteger,TestImpl>();
	public static void main(String[] args) {
		boolean condition = true;
		do {
		int choice;
		TestImpl t = new TestImpl();
		System.out.println("Enter your choice : ");
		System.out.println("1 - Login as Admin");
		System.out.println("2 - Register as Candidate");
		System.out.println("3 - Exit");
		choice=sc.nextInt();
		switch (choice) {
		case 1:
			t = login();
			condition = true;
			break;
		case 2:
			register();
			startTest();
			evaluate();
			condition = false;
			break;
		case 3:
			System.out.println("Exit!!");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid Choice");
			break;
		}
		}while(condition);
		
	}
	public static void evaluate() {
		// TODO Auto-generated method stub
		//System.out.println(lu);
		//System.out.println(lt);
		//System.out.println(lq);
		BigDecimal score = lu.get(1).getResult(lt.get(0)); 
		System.out.println("Score:"+score);
	}
	public static void startTest() {
		// TODO Auto-generated method stub
		boolean b = false;
		int n = lq.size();
		for(int i=0; i<n; i++) {
		Question q = lq.get(i);
		System.out.println(q.getQuestionTitle());
		System.out.println(q.getQuestionOptions());
		int choose = sc.nextInt();
		q.setChoosenAnswer(choose);
		lq.set(i, q);
		b = true;
		}
		if(b) {
		System.out.println("Test submitted successfully!!");
		}
	}
	public static boolean passwordValidation(String password)
    {
            boolean valid = true;
            if (password.length() < 8)
            {
                    valid = false;
            }
            String upperCaseChars = "(.*[A-Z].*)";
            if (!password.matches(upperCaseChars ))
            {
                    valid = false;
            }
            String lowerCaseChars = "(.*[a-z].*)";
            if (!password.matches(lowerCaseChars ))
            {
                    valid = false;
            }
            String numbers = "(.*[0-9].*)";
            if (!password.matches(numbers ))
            {
                    valid = false;
            }
            String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
            if (!password.matches(specialChars ))
            {
                    valid = false;
            }
            if (valid)
            {
                    valid = true;
            }
            return valid;
    }
	public static TestImpl login() {
		boolean con = false;
		Long userId = null;
		String userName = null;
		String password = null;
		try {
			System.out.print("UserID:");
			userId = sc.nextLong();
			if(userId == null) {
				throw new Exception();
			}
			con = true;
			System.out.print("username:");
			userName = sc.next();
			if(Character.isLowerCase(userName.charAt(0))) {
				con = false;
				throw new InvalidName(userName);			
			}
			con = true;
			System.out.print("password:");
			password = sc.next();
			if(passwordValidation(password)) {
				String userPassword = password;
				System.out.println("Admin login successful!!!");
			}
			else {
				con = false;
				throw new InvalidPassword(password);
			}
			con = true;
			}	
			catch(InvalidName e) {
					System.err.println("Invalid username "+e.getMessage());
			}
			catch(InvalidPassword e) { 
				System.err.println("Invalid Password type "+e.getMessage());
			}
			catch(Exception e) {
				System.err.println("UserID cannot be null!! "+e.getMessage());
			}
			if(con == true) {
				TestImpl test = new TestImpl();
				test = testMethod();
				BigInteger TestId = test.getTestId(); 
				TestsMap.put(TestId, test);
				/*int i=0;
				for(Question q:lt.get(0).getTestQuestions()) {
					lq.add(q.questionMethod());
					i++;
				}
				UserImpl u = new UserImpl(userId, userName, test, true, password);
				lu.add(u);*/
				return test;
			}
			else{
				System.out.println("Invalid Login!!!Try Again!!!");
				return null;
			}
	}
	public static void register() {
		System.out.print("Enter userID:");
		Long userId = sc.nextLong();
		System.out.println("Enter TestID:");
		BigInteger TestId = sc.nextBigInteger();
		UserImpl u = new UserImpl(userId);
		System.out.println("Candidate Register successfully!!!");
		u.assignTest(userId,TestId);
		lu.add(u);
		try {
			u.setUserTest(lt.get(0));
			System.out.println("Test Assigned Successfully!!!");
		}
		catch(Exception e) {
			System.err.println("No test available");
		}
	}
	public static TestImpl testMethod() {
		UserImpl u = new UserImpl();
		TestImpl t = new TestImpl();
		System.out.println("Adding Test:");
		t = u.addTest(t);
		return t;		
	}
}
