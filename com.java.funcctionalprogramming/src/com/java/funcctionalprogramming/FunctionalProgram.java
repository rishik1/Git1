package com.java.funcctionalprogramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalProgram {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charels", "Dickens", 60),
				new Person("Charels", "hollway", 88),
				new Person("Michale", "Schume", 19),
				new Person("Douglas", "Cost", 27)
				);
		
		
		Collections.sort(people , (p1,p2)->p1.getLastName().compareTo(p2.getLastName())); 
		
		System.out.println("printing all the data inside the function"); // predicate means condition
		performConditionally(people, p->true );
		
		System.out.println("printing all the person Last names start with C \n");
		performConditionally(people, p->p.getLastName().startsWith("C"));
		
		System.out.println("printing all the person First names start with C\n");
		performConditionally(people, p->p.getFirstName().startsWith("C"));
		
		
		
		System.out.println("\n Consumer :printing all the data inside the function\n"); // predicate means condition
		performConditionallyBehavior(people, p->true, p->System.out.println(p));
		
		System.out.println("Consumer : printing all the person Last names start with C \n");
		performConditionallyBehavior(people, p->p.getLastName().startsWith("C"), p->System.out.println(p));
		
		System.out.println("Consumer :printing all the person First names start with C\n");
		performConditionallyBehavior(people, p->p.getFirstName().startsWith("C"),p->System.out.println(p));
		
		
	}
	
	private static void performConditionally(List<Person> people, Predicate<Person> predicate){
		for(Person  p: people){
			if(predicate.test(p)){
				System.out.println(p.toString());
			}
		}
	}
	
	private static void performConditionallyBehavior(List<Person> people , Predicate<Person> predicate , Consumer<Person> consumer){
		for(Person p: people){
			if(predicate.test(p)){
				consumer.accept(p);
			}
		}
		
	}

}
