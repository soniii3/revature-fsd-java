package com.revature.app.varargs;

public class VarArgsDemo {

	public static void main(String[] args) {
		System.out.println(add(1, 2, 3, 4, 5));

	}
	public static int add(int name, int  ... numbers) {
		int total =0;
		for(int number : numbers) {
			total += number;
		}
		return total;
	}

}
