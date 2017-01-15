package com.hugomfcruz.algodesign.chapter2;

//http://www.programming-challenges.com/pg.php?page=downloadproblem&probid=110505&format=html
public class MultiplicationGame {

	public static Object findWinner(int n) {
		int a = new Double(Math.log(2 * (n - 1)) / (Math.log(2) + Math.log(9))).intValue();
		int b = new Double(Math.log(18 * (n - 1)) / (Math.log(2) + Math.log(9))).intValue();
		return (a + b) % 2 == 1 ? "Stan" : "Ollie";
	}

}
