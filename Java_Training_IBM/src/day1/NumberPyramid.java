package day1;

import java.util.Scanner;

public class NumberPyramid {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = 0;
	
		while (n < 1 || n > 20) {
			System.out.print("Enter a positive integer N (betweeb 1 & 20): ");
			n = scanner.nextInt();
			
			if(n < 1 || n > 20) {
				System.out.println("Invalid number! Please try again."); 
			}
		}
		
		System.out.println("\nGenerating Pyramid");
		
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(j + "");
			}
			System.out.println();
		}
		
		scanner.close();
	}
}
