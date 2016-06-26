package com.test;

public class Base {
	
	private static String baseName = "base";
	
	public Base(){
		System.out.println("ddddd");
		callName1();
	}
	
	public void callName1(){
		System.out.println(baseName);
	}
	
	static class Sub extends Base{
		private static String baseName = "sub";
		
		public Sub(){
			System.out.println("aaaa");
		}
		
		public Sub(String name){
		}
		
		public void callName(){
			System.out.println(baseName);
		}
	}
	
	public static void main(String[] args) {
		Base b = new Sub("aaa");
	}
}



