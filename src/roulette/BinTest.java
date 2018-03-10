package roulette;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class BinTest {
	
	Outcome streetBet = new Outcome("25-26-27 Street Bet", 11);
	Outcome red = new Outcome("Red",1);
	Outcome black = new Outcome("Black",1);
	Outcome third12 = new Outcome("Third 12", 2);
	Outcome cornerBet = new Outcome("25-26-28-29 Corner Bet", 8);
	Outcome cornerBet2 = new Outcome("26-27-29-30 Corner Bet", 8);
	Outcome col1 = new Outcome("Column 1", 2);
	Outcome col2 = new Outcome("Column 2", 2);
	Outcome col3 = new Outcome("Column 3", 2);
	
	@Test
	public void testBin() throws Exception {
		Bin bin25 = new Bin(new Outcome[] {streetBet, red, third12, cornerBet, col1});
		Bin bin26 = new Bin(new Outcome[] {streetBet, black, third12, cornerBet, cornerBet2, col2});
		
		assertEquals("[25-26-27 Street Bet (11:1), 25-26-28-29 Corner Bet (8:1), Column 1 (2:1), " +
				"Red (1:1), Third 12 (2:1)]", bin25.toString());
		assertEquals("[25-26-27 Street Bet (11:1), 25-26-28-29 Corner Bet (8:1), " +
				"26-27-29-30 Corner Bet (8:1), Black (1:1), Column 2 (2:1), Third 12 (2:1)]",
				bin26.toString());
	}

}
