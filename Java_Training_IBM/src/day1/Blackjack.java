package day1;

public class Blackjack {
	public static int blackjack(int a, int b) {
		if(a > 21) {
			a = 0;
		}
		if (b > 21) {
			b = 0;
		}
		return Math.max(a, b);
	}
	public static void main(String args[]) {
		System.out.println("--- Blackjack Test Time ---");
		
		System.out.println("blackjack(19,21) -> Expected: 21 | Got: " + blackjack(19, 21));
		System.out.println("blackjack(22,19) -> Expected: 19 | Got: " + blackjack(22, 19));
		System.out.println("blackjack(22,19) -> Expected: 0 | Got: " + blackjack(22, 50));
		
	}
	
}
