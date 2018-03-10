package roulette;

import java.text.MessageFormat;

public class Outcome {
	// Holds the name of the Outcome
	private String name;
	// Holds the payout odds for this Outcome
	private int odds;

	/**
	 * Sets the instance name and odds from the parameter name and odds.
	 * @param name (String) the name of this Outcome
	 * @param odds (int) the payout of this Outcome
	 */
	public Outcome(String name, int odds) {
		this.name = name;
		this.odds = odds;
	}
	
	public String getName() {
		return name;
	}
	
	public int getOdds() {
		return odds;
	}
	
	/**
	 * Multiply this Outcome's odds by the given amount. The product is returned.
	 * @param amount (int) amount being bet.
	 * @return (int) amount won based on the outcome's odds and the amount bet.
	 */
	public int winAmount(int amount) {
		return odds * amount;
	}
	
	/**
	 * Compare the name attributes of this and other
	 * @param other (Outcome) Another Outcome to compare against.
	 * @return (boolean) true if this name matches the other name
	 */
	public boolean equals(Outcome other) {
		return name.equals(other.getName());
	}
	
	/**
	 * Easy to read representation of this Outcome
	 * @return (String) String of the form "name (odds:1)"
	 */
	public String toString() {
		Object[] values = {name, new Integer(odds)};
		String msgTmpl = "{0} ({1}:1)";
		return MessageFormat.format(msgTmpl, values);
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
