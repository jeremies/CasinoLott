package roulette;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;

/**
 * BinBuilder creates the Outcomes for all of the 38 individual Bin on
 * a Roulette wheel.
 * @author quim
 *
 */
public class BinBuilder {
	/**
	 * Initializes the BinBuilder
	 */
	public BinBuilder() {
	}

	/**
	 * Creates the Outcome instances and uses the addOutcome() method
	 * to place each Outcome in the appropriate Bin of wheel.
	 * @param wheel (Wheel) The Wheel with the Bins that must be populated
	 * with Outcomes.
	 */
	public void buildBin(Wheel wheel) {
		// --- Straight bets ---
		for (int n=0; n<=36; n++) {
			Outcome straight = new Outcome("Number " + n, RouletteGame.STRAIGHT);
			wheel.addOutcome(n, straight);
		}
		Outcome doubleZero = new Outcome("Number 00", RouletteGame.STRAIGHT);
		wheel.addOutcome(37, doubleZero);
		
		// --- Split bets ---
		// Left-right split bets
		for (int r=0; r<12; r++) {
			for (int i=1; i<=2; i++) {
				int n = 3*r + i;
				String name = MessageFormat.format("Split {0}-{1}", n, n+1);
				Outcome split = new Outcome(name, RouletteGame.SPLIT);
				wheel.addOutcome(n, split);
				wheel.addOutcome(n+1, split);
			}
		}
		// Up-down split bets
		for (int n=1; n<=33; n++) {
			String name = MessageFormat.format("Split {0}-{1}", n, n+3);
			Outcome split = new Outcome(name, RouletteGame.SPLIT);
			wheel.addOutcome(n, split);
			wheel.addOutcome(n+3, split);
		}
		
		// --- Street bets ---
		for (int r=0; r<12; r++) {
			int n = 3*r + 1;
			String name = MessageFormat.format("Street {0}-{1}-{2}", n, n+1, n+2);
			Outcome street = new Outcome(name, RouletteGame.STREET);
			wheel.addOutcome(n, street);
			wheel.addOutcome(n+1, street);
			wheel.addOutcome(n+2, street);
		}
		
		// --- Corner bets ---
		for (int r=0; r<11; r++) {
			for (int i=1; i<=2; i++) {
				int n = 3*r + i;
				String name = MessageFormat.format("Corner {0}-{1}-{2}-{3}", n, n+1, n+3, n+4);
				Outcome corner = new Outcome(name, RouletteGame.CORNER);
				wheel.addOutcome(n, corner);
				wheel.addOutcome(n+1, corner);
				wheel.addOutcome(n+3, corner);
				wheel.addOutcome(n+4, corner);
			}
		}
		
		// --- Five number bet ---
		Outcome fiveNumber = new Outcome("Five number", RouletteGame.FIVE_NUMBER);
		wheel.addOutcome(0, fiveNumber);
		wheel.addOutcome(1, fiveNumber);
		wheel.addOutcome(2, fiveNumber);
		wheel.addOutcome(3, fiveNumber);
		wheel.addOutcome(37, fiveNumber);
		
		// --- Line bets ---
		for (int r=0; r<11; r++) {
			int n = 3*r + 1;
			String name = MessageFormat.format("Line {0}-{1}-{2}-{3}-{4}-{5}", n, n+1, n+2, n+3, n+4, n+5);
			Outcome line = new Outcome(name, RouletteGame.LINE);
			for (int i=0; i<6; i++)
				wheel.addOutcome(n+i, line);
		}
		
		// --- Dozen bets ---
		for (int d=0; d<3; d++) {
			Outcome dozen = new Outcome("Dozen " + (d+1), RouletteGame.DOZEN);
			for (int m=0; m<12; m++)
				wheel.addOutcome(12*d+m+1, dozen);
		}
		
		// --- Column bets ---
		for (int c=0; c<3; c++) {
			Outcome column = new Outcome("Column " + (c+1), RouletteGame.COLUMN);
			for (int r=0; r<12; r++)
				wheel.addOutcome(3*r+c+1, column);
		}

		// --- Even-Money bets ---
		Outcome red = new Outcome("Red", RouletteGame.EVEN_MONEY);
		Outcome black = new Outcome("Black", RouletteGame.EVEN_MONEY);
		Outcome even = new Outcome("Even", RouletteGame.EVEN_MONEY);
		Outcome odd = new Outcome("Odd", RouletteGame.EVEN_MONEY);
		Outcome high = new Outcome("High", RouletteGame.EVEN_MONEY);
		Outcome low = new Outcome("Low", RouletteGame.EVEN_MONEY);
		for (int n=1; n<=36; n++) {
			if (n <= 18)
				wheel.addOutcome(n, low);
			else
				wheel.addOutcome(n, high);
			if (n % 2 == 0)
				wheel.addOutcome(n, even);
			else
				wheel.addOutcome(n, odd);
			List<Integer> lred = Arrays.asList(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36);
			if (lred.contains(n))
				wheel.addOutcome(n, red);
			else
				wheel.addOutcome(n, black);
		}
		
	}
}
