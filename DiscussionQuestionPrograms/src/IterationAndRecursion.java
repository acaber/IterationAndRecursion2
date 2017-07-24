/**
 * File Name: IterationAndRecursion.java
 * Author: Rebecca Johnson
 * Date: 7/24/2017
 * Purpose: Calculates the nth term of multiples of 5 using 
 * 		iteration and recursion.
 */


import java.util.Scanner;

public class IterationAndRecursion {

	public static void main(String[] args) {
	
		int n;

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter n: ");
		n = keyboard.nextInt();
		
		System.out.println("Iterative: ");
		for(int i = 0; i < n; i++)
			System.out.println("n: " + i + " ----- result: " + iteration(i));
		
		
		System.out.println("\nRecursive: ");
		for(int i = 0; i < n; i++)
			System.out.println("n: " + i + " ----- result: " + recursion(i));
	}
	
	public static int recursion(int n) {
		if(n == 0) 
			return 0;
		else 
			return 5 * recursion(n - 1);
	}
	
	public static int iteration(int n) {
		
		int result = 0;
		
		if(n == 0) 
			return 0;
		else {
			for(int i = 1; i <= n; i++) 
				result = i * 5;	
		}	
		return result;
	}
}
