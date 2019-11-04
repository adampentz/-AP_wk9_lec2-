package edu.cgcc.cs260;
import java.util.Random;

public class Person {
	//members
	private String name;
	private int age;
	private boolean student;
	private static String[] randomFirstNames = new String[] {"Charles", "Joseph", "George", "John", "James", "Doris", "Barbara", "Virginia", "Dorothy", "Helen"};
	private static String[] randomLastNames = new String[] {"Brown", "Johnson", "Alpin", "Jackson", "Martin", "Anderson", "Wilson", "Robinson", "Green", "Smith"};
	
	//constructor
	public Person(String n, int a, boolean s) {
		name = n;
		age = a;
		student = s;
	}	
	
	//public member functions
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public boolean isStudent() {
		return student;
	}
	
	public static Person generatePerson() {
		String firstName = randomFirstNames[new Random().nextInt(randomFirstNames.length)];
		String lastName = randomLastNames[new Random().nextInt(randomLastNames.length)];
		int age = new Random().nextInt(((100 - 10) + 1) + 10);
		boolean student = new Random().nextBoolean();
		
		
		
		return new Person(firstName + " " + lastName, age, student);
	}
}
