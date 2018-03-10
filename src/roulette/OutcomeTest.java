package roulette;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OutcomeTest {
	
	private Outcome split12a;
	private Outcome split12b;
	private Outcome streetBet192021;
	
	public OutcomeTest() {
		split12a = new Outcome("1-2 Split",  17);
		split12b = new Outcome("1-2 Split",  17);
		streetBet192021 = new Outcome("19-20-21 Street Bet", 11);
	}

	@Test
	public void testEquality() {
		assertTrue(split12a.equals(split12b));
		assertFalse(split12a.equals(streetBet192021));
	}
	
	@Test
	public void testHash() {
		assertTrue(split12a.hashCode() == split12b.hashCode());
		assertFalse(split12a.hashCode() == streetBet192021.hashCode());
	}
	
	@Test
	public void testWinAmount() {
		assertEquals(51, split12a.winAmount(3));
		assertEquals(88, streetBet192021.winAmount(8));
	}
}
