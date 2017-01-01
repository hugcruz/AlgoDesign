package com.hugomfcruz.algodesign.chapter1;

//http://www.programming-challenges.com/pg.php?page=downloadproblem&probid=110101&format=html

public class ThreeNPlusOne {
	/**
	 * Calculates the maximum 3n+1 cycle length for all the integers between i
	 * and j
	 * 
	 * @param i
	 *            the lower bound of numbers to check
	 * @param j
	 *            the upper bound of numbers to check
	 * @return the maximum cycle length
	 */
	public static int calculateMaximumCycleLength(int i, int j) {
		int maximum = 0;
		for (; i <= j; ++i) {
			maximum = Math.max(maximum, calculateCycleLength(i));
		}

		return maximum;
	}

	/**
	 * Calculates the cycle length for "n", according to the 3n+1 rules: Start
	 * with an integer n. If n is even, divide by 2. If n is odd, multiply by 3
	 * and add 1. Repeat this process with the new value of n, terminating when
	 * n = 1.
	 * 
	 * @param n
	 *            the input number
	 * @return the cycle time for the number n
	 */
	private static int calculateCycleLength(int n) {
		int currentLength = 1;

		while (n != 1) {
			if (n % 2 == 1) {
				n = 3 * n + 1;
			} else {
				n = n / 2;
			}

			currentLength += 1;
		}

		return currentLength;
	}
}
