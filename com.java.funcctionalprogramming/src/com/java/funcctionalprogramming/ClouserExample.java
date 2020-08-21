package com.java.funcctionalprogramming;

import java.io.InputStream;
import java.io.OutputStream;

public class ClouserExample {
	
	public static void main(String [] args){
		int a=10;
		int b=20;
		
		doProcess(a, new Proccess() {
			
			@Override
			public void process(int i) {
				System.out.println(i+b); // frozen value of B passed inside the blocck of code to the fucntion
				//effectively final value of b as it s value cannot be changed
			}
		});
		
		
		doProcess(a, i->System.out.println(i+b));
		
	}

	public static void doProcess(int i ,Proccess p){
		p.process(i);
	}
	

}

interface Proccess{
	void process(int i);
}
