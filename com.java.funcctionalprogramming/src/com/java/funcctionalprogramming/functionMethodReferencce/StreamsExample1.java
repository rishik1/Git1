package com.java.funcctionalprogramming.functionMethodReferencce;

import java.util.Arrays;
import java.util.List;

import com.java.funcctionalprogramming.Person;

public class StreamsExample1 {

	public static void main(String[] args){

	List<Person> people = Arrays.asList(
			new Person("Charels", "Dickens", 60),
			new Person("Charels", "hollway", 88),
			new Person("Michale", "Schume", 19),
			new Person("Douglas", "Cost", 27)
			);
	
	
		people.stream()
		.filter(p->p.getFirstName().startsWith("C"))
		.forEach(p->System.out.println(p));
		
		
		System.out.println("terminal operation ");
		
		long count =people.stream()
		.filter(p->p.getLastName().startsWith("C"))
		.count();
		
		System.out.println(count); 
		
		
		
		System.out.println("Multiple streams using multi cores");
		long count1 =people.parallelStream()
		.filter(p->p.getLastName().startsWith("C"))
		.count();
		System.out.println(count1); 
		
		
		
		List<Integer> values= Arrays.asList(1,2,3,4,5,6);
		
		System.out.println("\n Doubling the values of list using streams api");
		System.out.println(values.stream()
		.map(value -> value*2)
		.reduce(0,(i,j) -> i+j ));
		
		
		
	}
}
