package com.hugomfcruz.algodesign.chapter2;

import java.util.List;

//http://www.programming-challenges.com/pg.php?page=downloadproblem&probid=110501&format=html
public class PrimaryArithmetic {

	public static int carryOperations(List<Integer> list1, List<Integer> list2) {
		int carryOperations = 0;
		int carryOver = 0;

		for (int i = list1.size() - 1; i >= 0; i--) {
			if (list1.get(i) + list2.get(i) + carryOver > 9) {
				carryOperations += 1;
				carryOver = 1;
			} else {
				carryOver = 0;
			}
		}

		return carryOperations;
	}

}
