package com.java.funcctionalprogramming.functionMethodReferencce;

import java.util.Arrays;
import java.util.List;

import com.java.funcctionalprogramming.Person;

public class CollectionIteration {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charels", "Dickens", 60),
				new Person("Charels", "hollway", 88),
				new Person("Michale", "Schume", 19),
				new Person("Douglas", "Cost", 27)
				);
		
		System.out.println("External interator1 in java \n ");
		for(int i=0; i< people.size() ; i++){
			System.out.println(people.get(i));
		}
		
		System.out.println("External interator2 in java \n");
		for(Person p : people){
			System.out.println(p);
		}
		
		
		System.out.println("Internal Iterator in Java \n");
		people.forEach(p-> System.out.println(p));
		
		System.out.println("Internal Iterator in Java using method refernce \n");
		people.forEach(System.out::println);
		
	}

}
