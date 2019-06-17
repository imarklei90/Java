package edu.sse.ustc.exception;

import java.util.Scanner;

/**
 * Stack Trace Analysis
 * @author iustc
 *
 */
public class Exception_StackTraceAnalysis {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("input n: ");
		int n = scanner.nextInt();
		int ret = factorial(n);
		System.out.println(ret);
	}
	
	public static int factorial(int n) {
		int ret;
		
		Throwable t = new Throwable();
		StackTraceElement[] elements = t.getStackTrace();
		
		for(StackTraceElement element : elements) {
			System.out.println(element);
		}
		
		if(n < 1) {
			ret = 1;
		}else {
			ret = n * factorial(n - 1);
		}
		
		return ret;
	}
}
