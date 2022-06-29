package nz.ac.auckland.se281.a1;

/**
 * University of Auckland
 * <p>
 * SOFTENG 281 - SEMESTER 1 - 2022
 * <p>
 * ASSIGNMENT 1 (A1)
 * <p>
 * Basics Class
 */
public class Basics {

	/**
	 * Returns the total number of cents. For example, it returns 320 given
	 * <code>dollars
	 * = 3</code> and <code>cents = 20</code>. If either dollars or cents are
	 * invalid (have negative values) the method returns -1.
	 * 
	 * @param dollars
	 * @param cents
	 * @return the total amount in cents, or -1 if dollars or cents are invalid.
	 */
	public static int getTotalAsCents(int dollars, int cents) {
		// Converts an amount of dollars and cents to only cents
		if ((dollars < 0) || (cents < 0)) {
			return -1;
		} else {
			return (dollars * 100 + cents);
		}
	}

	/**
	 * Returns the sum of two money amounts as cents. For example, it returns 530
	 * given <code>moneyOneDollars = 3</code> <code>moneyOneCents = 0</code>,
	 * <code>moneyTwoDollars = 2</code>, and <code>moneyTwoCents = 30</code>.
	 * <p>
	 * if any of the two amounts contains invalid dollars or cents (have negative
	 * values) the method returns -1.
	 * 
	 * @param moneyOneDollars the dollars of the first amount
	 * @param moneyOneCents   the cents of the first amount
	 * @param moneyTwoDollars the dollars of the second amount
	 * @param moneyTwoCents   the cents of the second amount
	 * @return the sum of two money amounts as cents, or -1 if invalid dollars or
	 *         cents are provided
	 */
	public static int sumAsCents(int moneyOneDollars, int moneyOneCents, int moneyTwoDollars, int moneyTwoCents) {
		// Finds the sum of two amounts of money and finds the total value in cents
		if (getTotalAsCents(moneyOneDollars, moneyOneCents) == -1
				|| (getTotalAsCents(moneyTwoDollars, moneyTwoCents) == -1)) {
			return -1;
		} else {
			return (getTotalAsCents(moneyOneDollars, moneyOneCents) + getTotalAsCents(moneyTwoDollars, moneyTwoCents));
		}
	}

	/**
	 * Returns the sum of two money amounts, as cents, split in half. For example,
	 * it returns 265 given <code>moneyOneDollars = 3</code>
	 * <code>moneyOneCents = 0</code>, <code>moneyTwoDollars = 2</code>, and
	 * <code>moneyTwoCents = 30</code>.
	 * <p>
	 * if any of the two amounts contains invalid dollars or cents (have negative
	 * values) the method returns -1.
	 * <p>
	 * if the total sum of two money amounts as cents is an odd value, when we do
	 * the split we ignore the extra cent. For example, if the two amounts total
	 * <code>153</code> cents comes out to <code>76</code> cents.
	 * 
	 * @param moneyOneDollars the dollars of the first amount
	 * @param moneyOneCents   the cents of the first amount
	 * @param moneyTwoDollars the dollars of the second amount
	 * @param moneyTwoCents   the cents of the second amount
	 * @return two money amounts, as cents, split in half, or -1 if invalid dollars
	 *         or cents are provided
	 */
	public static int splitAsCents(int moneyOneDollars, int moneyOneCents, int moneyTwoDollars, int moneyTwoCents) {
		// Finds the total amount of money in cents and splits the total in half
		if (sumAsCents(moneyOneDollars, moneyOneCents, moneyTwoDollars, moneyTwoCents) == -1) {
			return -1;
		} else {
			return (sumAsCents(moneyOneDollars, moneyOneCents, moneyTwoDollars, moneyTwoCents) / 2);
		}
	}

}
