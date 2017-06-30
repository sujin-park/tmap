package com.secondproject.util;

public class Test {
	public static void main(String[] args) {
		int tmp = 15;
		int pageSize = 100;
		System.out.println(tmp / pageSize);
		System.out.println(tmp / pageSize * pageSize + 1);
		System.out.println(tmp / pageSize * pageSize + pageSize);
	}
}
