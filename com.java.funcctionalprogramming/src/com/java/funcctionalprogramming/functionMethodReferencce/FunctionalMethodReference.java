package com.java.funcctionalprogramming.functionMethodReferencce;

public class FunctionalMethodReference {
	
	public static void main(String[] args){
		
		Thread t = new Thread(()->printMessage());
		t.start();
		
		Thread t1 = new Thread(FunctionalMethodReference::printMessage);
		t1.start();
	}

	public static void printMessage(){
		System.out.println("Hello");
	}
}
