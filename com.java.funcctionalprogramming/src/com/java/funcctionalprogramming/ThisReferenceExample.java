package com.java.funcctionalprogramming;

import java.io.InputStream;
import java.io.OutputStream;

public class ThisReferenceExample {


	public void execute(){
		doProcess(10, i->{
			System.out.println("value of i is "+ i);
			System.out.println(this); 
		});
	}
	
	public String toString(){
		return "This is an main ThisReferencce object";
		
	}
	
	public static void main(String [] args){


		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		thisReferenceExample.doProcess(10, new Proccess() {
			
			@Override
			public void process(int i) {
				System.out.println("value of i is "+ i);
				System.out.println(this);
			}
			
			public String toString(){
				return "This is an Anonymus inner calss";
			}
		});
		
		thisReferenceExample.doProcess(10, i->{
			System.out.println("value of i is "+ i);
			//System.out.println(this);  tis does not work for static variables method
		});
	}

	public static void doProcess(int i ,Proccess p){
		p.process(i);
	}
	
	public interface Process{
		void process(int i);
	}
}
