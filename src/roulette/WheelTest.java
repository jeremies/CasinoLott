package roulette;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

public class WheelTest {
	Outcome streetBet = new Outcome("25-26-27 Street Bet", 11);
	Outcome red = new Outcome("Red",1);
	Outcome black = new Outcome("Black",1);
	Outcome third12 = new Outcome("Third 12", 2);
	Outcome cornerBet = new Outcome("25-26-28-29 Corner Bet", 8);
	Outcome cornerBet2 = new Outcome("26-27-29-30 Corner Bet", 8);
	Outcome col1 = new Outcome("Column 1", 2);
	Outcome col2 = new Outcome("Column 2", 2);
	Outcome col3 = new Outcome("Column 3", 2);
	
	Bin bin25 = new Bin(new Outcome[] {streetBet, red, third12, cornerBet, col1});
	Bin bin26 = new Bin(new Outcome[] {streetBet, black, third12, cornerBet, cornerBet2, col2});


	/**
	 * Creates an instance of wheel, establish that Outcomes can be added to the Wheel,
	 * and that Bins can be selected from the wheel with the next() method.
	 * @throws Exception
	 */
	@Test
	public void wheelTest() throws Exception {
		Random rng = new NonRandom();
		rng.setSeed(25L);

		Wheel wheel = new Wheel(rng);

		assertEquals(true, wheel.addOutcome(25, streetBet));
		assertEquals(true, wheel.addOutcome(25, red));
		assertEquals(true, wheel.addOutcome(25, third12));
		assertEquals(true, wheel.addOutcome(25, cornerBet));
		assertEquals(true, wheel.addOutcome(25, col1));

		assertEquals(true, wheel.addOutcome(26, streetBet));
		assertEquals(true, wheel.addOutcome(26, black));
		assertEquals(true, wheel.addOutcome(26, third12));
		assertEquals(true, wheel.addOutcome(26, cornerBet));
		assertEquals(true, wheel.addOutcome(26, cornerBet2));
		assertEquals(true, wheel.addOutcome(26, col2));
		
		assertEquals(bin25.toString(), wheel.next().toString());
		assertEquals(bin25.toString(), wheel.next().toString());
		assertEquals(bin25.toString(), wheel.next().toString());
	}

}
