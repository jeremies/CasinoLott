package roulette;

import java.util.Random;

public class Scratch {
	public static void main(String[] args) {
		Random rng = new NonRandom();
		rng.setSeed(32412L);
		System.out.println(rng.nextInt());
		System.out.println(rng.nextInt());
	}

}
