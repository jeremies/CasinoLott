package roulette;

import java.util.Random;

public class NonRandom extends Random {
	// The non-random value to return
	long value;
	
	/**
	 * Creates a non-random "random" number generator
	 */
	public NonRandom() {
	}
	
	/**
	 * Saves this value as the next value to return.
	 * @param value (long) the value to return next.
	 */
	@Override
	public void setSeed(long value) {
		this.value = value;
	}
	
	/**
	 * Returns the cast to int of the value provided by NonRandom.setSeed().
	 * @param bits (int)
	 * @return the cast to int of the seed value.
	 */
	@Override
	public int next(int bits) {
		return (int) value;
	}
}
