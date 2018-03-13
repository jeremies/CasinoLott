package roulette;

import java.util.Random;
import java.util.Vector;

/**
 * Wheel contains the 38 individual Bins on a Roulette Wheel, plus a random number
 * generator. It can select a Bin at random, simulating a spin of the Roulette Wheel.
 * @author quim
 *
 */
public class Wheel {
	// Contains the individual Bin instances
	private Vector<Bin> bins = new Vector<>(38);
	
	// The random number generator to use to select a Bin from the bins collection
	private Random rng;
	
	/**
	 * Creates a new Wheel with 38 empty Bins. It will also create a new random
	 * number generator instance.
	 * @param rng (Random) A "random" number generator. For testing, this may be
	 * a non-random number generator.
	 */
	public Wheel(Random rng) {
		for (int i=0; i<38; i++)
			bins.add(new Bin());
		this.rng = rng;
	}
	
	/**
	 * Adds the given Outcome to the Bin with the given number.
	 * @param bin (int) bin number, in the range zero to 37 (inclusive).
	 * @param outcome (Outcome) the Outcome to add to this Bin
	 * @return (boolean)
	 */
	public boolean addOutcome(int bin, Outcome outcome) {
		return bins.get(bin).add(outcome);
	}
	
	/**
	 * Generates a random number between 0 and 37, and returns the randomly
	 * selected Bin.
	 * @return (Bin) A Bin selected at random from the wheel.
	 */
	public Bin next() {
		return bins.get(rng.nextInt(38));
	}
	
	/**
	 * Returns the given Bin from the internal collection.
	 * @param bin (int) bin number, in the range zero to 37 (inclusive).
	 * @return (Bin) the requested Bin.
	 */
	public Bin getBin(int bin) {
		return bins.get(bin);
	}
}
