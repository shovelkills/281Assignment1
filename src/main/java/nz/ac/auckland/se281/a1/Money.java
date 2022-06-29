package nz.ac.auckland.se281.a1;

/**
 * University of Auckland
 * <p>
 * SOFTENG 281 - SEMESTER 1 - 2022
 * <p>
 * ASSIGNMENT 1 (A1)
 * <p>
 * Money Class
 */
public class Money {
	// class attributes
	private int dollars;
	private int cents;

	/**
	 * Construct a Money instance with given initial dollar and cent components
	 * 
	 * If a Money instance is constructed with an invalid <code>dollars</code> or
	 * <code>cents</code>, then that value is set to 0
	 *
	 * @param dollars
	 * @param cents
	 */
	public Money(int dollars, int cents) {
		// checks if the dollar and cent components are valid
		if ((dollars < 0) && (cents < 0)) {
			this.dollars = 0;
			this.cents = 0;
		} else if (dollars < 0) {
			this.dollars = 0 + cents / 100;
			this.cents = cents % 100;
		} else if (cents < 0) {
			this.dollars = dollars;
			this.cents = 0;
		} else {
			this.dollars = dollars + cents / 100;
			this.cents = cents % 100;
		}
	}

	/**
	 * Default constructor
	 * 
	 * the default value of <code>dollars</code> and <code>cents</code> is 0.
	 * 
	 */
	public Money() {
		// Makes the default constructor dollars and cents equal to zero
		this.dollars = 0;
		this.cents = 0;
	}

	/**
	 * returns the dollars component
	 *
	 * @return
	 */
	public int getDollars() {
		// returns the dollars component
		return dollars;
	}

	/**
	 * returns the cents component
	 *
	 * @return
	 */
	public int getCents() {
		// returns the cents component
		return cents;
	}

	/**
	 * returns the total amount as cents
	 *
	 * @return
	 */
	public int getTotalAsCents() {
		// returns the total amount as cents
		return Basics.getTotalAsCents(this.dollars, this.cents);
	}

	/**
	 * add the specified dollar amount to this Money
	 * 
	 * if <code>dollars</code> is negative then nothing changes
	 * 
	 * @param dollars amount to add
	 */
	public void addDollars(int dollars) {
		// adds an amount of dollars
		if (dollars < 0) {
			return;
		}
		this.dollars += dollars;
	}

	/**
	 * add the specified cents amount to this Money
	 * 
	 * if <code>cents</code> is negative then nothing changes
	 * 
	 * @param cents amount to add
	 */
	public void addCents(int cents) {
		// adds an amount of cents
		if (cents < 0) {
			return;
		}
		this.cents += cents;
		if (this.cents >= 100) {
			this.dollars += this.cents / 100;
			this.cents = this.cents % 100;
		}
	}

	/**
	 * subtract the specified dollar amount from this Money
	 * 
	 * if <code>dollars</code> is negative then nothing changes. if it is attempted
	 * to decrease the money by an amount that is larger than the available money
	 * nothing changes
	 * 
	 * @param dollars amount to subtract
	 */
	public void subtractDollars(int dollars) {
		// subtracts an amount of dollars
		if ((Basics.getTotalAsCents(this.dollars, this.cents) > dollars * 100) && (dollars > 0)) {
			this.dollars -= dollars;
		}
	}

	/**
	 * subtract the specified cents amount from this Money
	 * 
	 * if <code>cents</code> is negative then nothing changes. if it is attempted to
	 * decrease the money by an amount that is larger than the available money
	 * nothing changes
	 * 
	 * @param cents
	 */
	public void subtractCents(int cents) {
		// subtracts an amount of cents
		if ((Basics.getTotalAsCents(this.dollars, this.cents) > cents) && (cents > 0)) {
			this.cents -= cents;
			if (this.cents < 0) {
				this.dollars -= 1 + this.cents / 100;
				this.cents = this.cents % 100 + 100;
			}
		}
	}

	/**
	 * add the other Money amount to this Money.
	 * 
	 * The method does not affect the <code>other</code> Money instance. We assume
	 * that the <code>other</code> object has a valid amount.
	 * 
	 * @param other Money instance to add to the current instance
	 */
	public void add(Money other) {
		// adds two value of money together
		addCents(other.cents);
		addDollars(other.dollars);
	}

	/**
	 * subtract the other Money amount from this Money
	 *
	 * The method does not affect the <code>other</code> Money instance. We assume
	 * that the <code>other</code> object has a valid amount.
	 *
	 * @param other Money instance to subtract to the current instance
	 */
	public void subtract(Money other) {
		// subtracts two values of money from each other
		subtractCents(other.cents);
		subtractDollars(other.dollars);

	}

	/**
	 * split the total amount of Money with the other instance.
	 * 
	 * The method will change the amount of both the current instance and the
	 * <code>other</code> instance. We assume that the <code>other</code> object has
	 * a valid amount.
	 * 
	 * 
	 * 
	 * @param other Money instance to split with
	 */
	public void split(Money other) {
		// Splits two amounts of money when added together
		int totalSplitInCents = Basics.splitAsCents(this.dollars, this.cents, other.dollars, other.cents);
		int splitDollars = totalSplitInCents / 100;
		int splitCents = totalSplitInCents % 100;
		this.dollars = splitDollars;
		this.cents = splitCents;
		other.dollars = splitDollars;
		other.cents = splitCents;

	}

}
