package com.weige.iterator.test;

public class SumTest {

	public static void main(String[] args) {
		int i = 100;
		int sum =sum(100);
		System.out.println(sum);
	}

	public static int sum (int i) {
		if(i!=0) {
			i--;
			return sum(i)+i;
		} else {
			return 0;
		}
	}
}
