package org.java.program;

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Masukkan Angka");
		int a=sc.nextInt();
		int b=sc.nextInt();
		System.out.println("Masukkan operator apa yang ada ingin gunakan");
		char op=sc.next().charAt(0);
		switch(op) {
		case'+' :System.out.println(a+b);
		break;
		case'-' :System.out.println(a-b);
		break;
		case'x' :System.out.println(a*b);
		break;
		case'/' :System.out.println(a/b);
		break;
		default:System.out.println();
		}
	}
}
