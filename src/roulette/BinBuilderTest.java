package roulette;

import java.util.Random;

import org.junit.Test;

public class BinBuilderTest {

	/**
	 * Invokes buildBin method to create Outcome instances.
	 * @throws Exception
	 */
	@Test
	public void binBuilderTest() throws Exception {
		Wheel wheel = new Wheel(new Random());
		new BinBuilder().buildBin(wheel);
	}
}
