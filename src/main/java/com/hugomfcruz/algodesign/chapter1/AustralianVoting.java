package com.hugomfcruz.algodesign.chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//http://www.programming-challenges.com/pg.php?page=downloadproblem&probid=110108&format=html

public class AustralianVoting {

	/**
	 * Find winner of election using Australian rules
	 * @param candidates the list of candidates
	 * @param ballots the list of ballots
	 * @return the name of the winner
	 */
	public static String getWinner(List<String> candidates, List<List<Integer>> ballots) {
		Optional<String> winner = Optional.empty();

		while (!winner.isPresent()) {
			int[] results = calculateResults(candidates, ballots);
			winner = findWinner(candidates, ballots.size(), results);
			if (!winner.isPresent()) {
				int eliminatedCandidateNumber = getLowestRankedCandidate(results);
				ballots = recalculateBallots(ballots, eliminatedCandidateNumber);
			}
		}

		return winner.get();
	}

	/**
	 * Calculates the results of the elections in the current round
	 * @param candidates the list of candidates
	 * @param ballots the ballots for the current round
	 * @return the results in the form of the number of first choice votes for each candidate
	 */
	private static int[] calculateResults(List<String> candidates, List<List<Integer>> ballots) {
		int[] results = new int[candidates.size()];
		for (int i = 0; i < results.length; ++i) {
			results[i] = 0;
		}

		for (List<Integer> ballot : ballots) {
			results[ballot.get(0) - 1] += 1;
		}

		return results;
	}

	/**
	 * Finds the winner of the election, or returns an empty Optional if the winner
	 * cannot be determined in the current round
	 * @param candidates the list of candidates
	 * @param totalVotes the total amount of ballots registered
	 * @param results the current results
	 * @return the winner, if found. Optional.empty otherwise.
	 */
	private static Optional<String> findWinner(List<String> candidates, int totalVotes, int[] results) {
		for (int i = 0; i < results.length; ++i) {
			if ((((float) results[i]) / totalVotes) > 0.5) {
				return Optional.of(candidates.get(i));
			}
		}

		return Optional.empty();
	}
	
	/**
	 * Finds the number of the lowest ranked candidate
	 * @param results the current results of the election
	 * @return the number of the lowest ranked candidate
	 */
	private static int getLowestRankedCandidate(int[] results) {
		int minimumVotes = Integer.MAX_VALUE;
		int lowestRankedCandidate = -1;

		for (int i = 0; i < results.length; ++i) {
			if (results[i] < minimumVotes) {
				lowestRankedCandidate = i;
			}
		}

		return lowestRankedCandidate;
	}
	
	/**
	 * Recalculates the ballots removing the top votes for the lowest scoring candidate
	 * @param ballots the original ballots
	 * @param eliminatedCandidateNumber the lowest candidate number
	 * @return the recalculated ballots
	 */
	private static List<List<Integer>> recalculateBallots(List<List<Integer>> ballots, int eliminatedCandidateNumber) {
		List<List<Integer>> recalculatedBallots = new ArrayList<>();
		for (List<Integer> ballot : ballots) {
			if (ballot.get(0).equals(eliminatedCandidateNumber)) {
				recalculatedBallots.add(ballot.subList(1, ballot.size()));
			} else {
				recalculatedBallots.add(ballot);
			}
		}
		return recalculatedBallots;
	}
}
