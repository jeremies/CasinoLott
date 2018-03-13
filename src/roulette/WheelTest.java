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
	
	/**
	 * Creates and initializes a Wheel. Check selected bins for correct Outcomes.
	 */
	@Test
	public void wheelTest2() throws Exception {
		Wheel wheel = new Wheel(new Random());
		new BinBuilder().buildBin(wheel);
		
		assertEquals("[Five number (6:1), Number 0 (35:1)]", wheel.getBin(0).toString());
		assertEquals("[Five number (6:1), Number 00 (35:1)]", wheel.getBin(37).toString());
		assertEquals("[Column 1 (2:1), Corner 1-2-4-5 (8:1), Dozen 1 (2:1), Five number (6:1), Line 1-2-3-4-5-6 (5:1), Low (1:1), Number 1 (35:1), Odd (1:1), Red (1:1), Split 1-2 (17:1), Split 1-4 (17:1), Street 1-2-3 (11:1)]", wheel.getBin(1).toString());
		assertEquals("[Black (1:1), Column 2 (2:1), Corner 16-17-19-20 (8:1), Corner 17-18-20-21 (8:1), Corner 19-20-22-23 (8:1), Corner 20-21-23-24 (8:1), Dozen 2 (2:1), Even (1:1), High (1:1), Line 16-17-18-19-20-21 (5:1), Line 19-20-21-22-23-24 (5:1), Number 20 (35:1), Split 17-20 (17:1), Split 19-20 (17:1), Split 20-21 (17:1), Split 20-23 (17:1), Street 19-20-21 (11:1)]", wheel.getBin(20).toString());
	}
}
