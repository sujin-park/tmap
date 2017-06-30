package com.secondproject.util;

public class Test extends ParentTest{
	
	public Test() {
		System.out.println("child!!");
	}
	
	public static void main(String[] args) {
		
		new Test();
		int tmp = 15;
		int pageSize = 100;
		System.out.println(tmp / pageSize);
		System.out.println(tmp / pageSize * pageSize + 1);
		System.out.println(tmp / pageSize * pageSize + pageSize);
	}
}
