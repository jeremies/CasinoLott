package roulette;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class Bin {
	// A Set that holds the connection of individual Outcomes.
	private Set<Outcome> outcomes;

	/**
	 * Creates an empty Bin. Outcomes can be added to it later.
	 */
	public Bin() {
		outcomes = new TreeSet<>();
	}
	
	/**
	 * Loads the outcomes collection using elements of the given array.
	 * @param outcomes (Outcome[] array) A primitive array of Outcomes.
	 */
	public Bin(Outcome[] outcomes) {
		this();
		for (Outcome outcome: outcomes)
			this.outcomes.add(outcome);
	}
	
	/**
	 * Loads the outcomes collection using elements of the given collection.
	 * @param outcomes (Collection) A collection of Outcomes.
	 */
	public Bin(Collection<Outcome> outcomes) {
		this();
		this.outcomes.addAll(outcomes);
	}
	
	/**
	 * Adds an Outcome to this bin.
	 * @param outcome (Outcome) An Outcome to add to this bin
	 * @return (boolean) 
	 */
	public boolean add(Outcome outcome) {
		return outcomes.add(outcome);
	}
	
	/**
	 * An easy-to-read representation of the list of Outcomes in this Bin
	 * @return (String) String of the form '[outcome, outcome, ...]'
	 */
	public String toString() {
		return outcomes.toString();
	}
}
