package com.java.funcctionalprogramming.functionMethodReferencce;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.java.funcctionalprogramming.Person;

public class FunctionalMethodReference2 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
				new Person("Charels", "Dickens", 60),
				new Person("Charels", "hollway", 88),
				new Person("Michale", "Schume", 19),
				new Person("Douglas", "Cost", 27)
				);
		
		
		Collections.sort(people , (p1,p2)->p1.getLastName().compareTo(p2.getLastName())); 

		
		System.out.println("Consumer :printing all the person First names start with C\n");
		performConditionallyBehavior(people, p->p.getFirstName().startsWith("C"),p->System.out.println(p));
		
		performConditionallyBehavior(people, p->true , System.out::println);
		performConditionallyBehavior(people, p->p.getFirstName().startsWith("C"), System.out::println);
		
	}
	

	
	private static void performConditionallyBehavior(List<Person> people , Predicate<Person> predicate , Consumer<Person> consumer){
		for(Person p: people){
			if(predicate.test(p)){
				consumer.accept(p);
			}
		}
		
	}

}
