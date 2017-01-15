package com.hugomfcruz.algodesign.chapter2;

//http://www.programming-challenges.com/pg.php?page=downloadproblem&probid=110701&format=html
public class LightMoreLight {
	public static Object isLastLightOn(int n) {
		boolean lastSwitchOn = false;

		// first and last times, light is switched
		for (int i = 2; i <= n / 2; ++i) {
			if (n % i == 0) {
				lastSwitchOn = !lastSwitchOn;
			}
		}

		return lastSwitchOn;
	}

}
