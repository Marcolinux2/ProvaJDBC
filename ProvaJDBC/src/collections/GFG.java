package collections;

import java.io.*;
import java.lang.*;
import java.util.*;

class Student {
	// ******************************
	// io sono un commento
	// nuovo commento
	// ******************************
	
	//nuovo branch
	int rollno;
	String name, address;

	public Student(int rollno, String name, String address) {

		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}

	public String toString() {

		// I'm a simple test
			
		// Returning attributes of Student
		return this.rollno + " " + this.name + " " + this.address;
	}
}

class Sortbyroll implements Comparator<Student> {

	public int compare(Student a, Student b) {
		return a.rollno - b.rollno;
	}
}

class Sortbyname implements Comparator<Student> {
	public int compare(Student a, Student b) {
		return a.name.compareTo(b.name);
	}
}

class GFG {

	public static void main(String[] args) {

		// Creating an empty ArrayList of Student type
		ArrayList<Student> ar = new ArrayList<Student>();

		// Adding entries in above List
		// using add() method
		ar.add(new Student(111, "Mario", "london"));
		ar.add(new Student(131, "Roberto", "nyc"));
		ar.add(new Student(121, "Franco", "jaipur"));
		ar.add(new Student(101, "Luigi", "Hongkong"));

		// Display message on console for better readability
		System.out.println("Unsorted");

		// Iterating over entries to print them
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

		// Sorting student entries by roll number
		Collections.sort(ar, new Sortbyroll());

		// Display message on console for better readability
		System.out.println("\nSorted by rollno");

		// Again iterating over entries to print them
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

		// Sorting student entries by name
		Collections.sort(ar, new Sortbyname());

		// Display message on console for better readability
		System.out.println("\nSorted by name");

		// // Again iterating over entries to print them
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));
	}
}
