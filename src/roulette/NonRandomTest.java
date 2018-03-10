package roulette;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NonRandomTest {

	@Test
	public void nonRandomTest() throws Exception {
		NonRandom rng = new NonRandom();
		rng.setSeed(3L);
		assertEquals(3, rng.nextInt());
		assertEquals(3, rng.nextInt());
		assertEquals(3, rng.nextInt());
	}
}
