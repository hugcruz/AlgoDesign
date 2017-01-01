package com.hugomfcruz.algodesign.chapter1;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

//http://www.programming-challenges.com/pg.php?page=downloadproblem&probid=110103&format=html

public class TheTrip {

	/**
	 * Calculates the total amount of money that needs to be exchanged
	 * in order to evenly distribute the expenses between all the 
	 * participants in the trip
	 * @param expenses the list of expenses per participant
	 * @return the total amount of money that needs to be exchanged
	 */
	public static BigDecimal calculateTotalMoneyExchangedToEvenExpenses(List<BigDecimal> expenses) {
		BigDecimal target = getTargetValue(expenses);

		BigDecimal moneyExchanged = BigDecimal.ZERO;

		for (int idx = 0; idx < expenses.size(); ++idx) {

			if (expenseNeedsAdjustment(expenses.get(idx), target)) {
				BigDecimal moneyToAdjust = expenses.get(idx).subtract(target);

				adjustWithOthers(
						expenses,
						idx + 1,
						moneyToAdjust,
						target);
				
				moneyExchanged = moneyExchanged.add(moneyToAdjust.abs());
			}
		}

		return moneyExchanged;
	}

	/**
	 * Is the expense already in the target value?
	 * 
	 * @param value the value of the expense
	 * @param target the target expense value
	 * @return true if the expense needs adjustment
	 */
	private static boolean expenseNeedsAdjustment(BigDecimal value, BigDecimal target) {
		return value.compareTo(target) != 0;
	}

	/**
	 * Calculates the target values, where the expenses are evenly distributed
	 * 
	 * @param expenses the list of expenses
	 * @return the value of the evenly distributed expense
	 */
	private static BigDecimal getTargetValue(List<BigDecimal> expenses) {
		return expenses.stream()
				.reduce((a, b) -> a.add(b)) //sum all
				.map(a -> a.divide(new BigDecimal(String.valueOf(expenses.size())))) //divide by size
				.orElseThrow(IllegalStateException::new);
	}

	/**
	 * Performs one adjustment step
	 * 
	 * @param expenses the list of expenses per participant
	 * @param idx the index currently being adjusted
	 * @param moneyToAdjust the amount of money that needs to be adjusted in the current step
	 * @param target the target evenly distributed amount
	 */
	private static void adjustWithOthers(List<BigDecimal> expenses, int idx, BigDecimal moneyToAdjust,
			BigDecimal target) {

		for (; idx < expenses.size(); ++idx) {
			if (moneyToAdjust.compareTo(BigDecimal.ZERO) == 0)
				return;

			BigDecimal expense = expenses.get(idx);

			if (getPredicate(target, moneyToAdjust).test(expense)) {
				BigDecimal adjustment = min(target.subtract(expense), moneyToAdjust);

				//update changed expense and total money to exchange in the step
				expenses.set(idx, expenses.get(idx).add(adjustment));
				moneyToAdjust = moneyToAdjust.add(adjustment);
			}
		}
	}

	/**
	 * Creates the predicate function to determine if an expense is to be
	 * considered for adjustment. Rule applies is to only remove money from
	 * expenses above the target and only give money to expenses below the
	 * target.
	 * 
	 * @param target the target expense value
	 * @param moneyToAdjust the current difference that needs adjusting
	 * @return a Predicate function to determine if the value is to be
	 * considered for the current adjustment operation
	 */
	private static Predicate<BigDecimal> getPredicate(BigDecimal target, BigDecimal moneyToAdjust) {
		return moneyToAdjust.signum() < 0 ?
			(t) -> t.compareTo(target) > 0:
			(t) -> t.compareTo(target) < 0;
	}
	
	/**
	 * Utility method to get the minimum of 2 BigDecimals
	 * 
	 * @param a a BigDecimal
	 * @param b a BigDecimal
	 * @return the minimum of the 2 BigDecimals
	 */
	private static BigDecimal min(BigDecimal a, BigDecimal b) {
		return a.compareTo(b) < 0 ? a : b;
	}

}
