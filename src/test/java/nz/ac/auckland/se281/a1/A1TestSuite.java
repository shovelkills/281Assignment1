package nz.ac.auckland.se281.a1;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ //
		A1TestSuite.Task1Test.class, // TASK1
		A1TestSuite.Task2Test.class, // TASK2
		A1TestSuite.Task3Test.class, // TASK3
		A1TestSuite.Task4Test.class // TASK4
//  A1TestSuite.YourTests.class // student-defined tests (facultative)
})

public class A1TestSuite {

	@FixMethodOrder(MethodSorters.JVM)
	public static class Task1Test {

		@Test
		public void testTotalCentsValid() {
			int totalAmount = Basics.getTotalAsCents(1, 25);
			assertEquals(125, totalAmount);
			assertEquals(5, Basics.getTotalAsCents(0, 5));
			assertEquals(2075, Basics.getTotalAsCents(20, 75));
			assertEquals(130, Basics.getTotalAsCents(0, 130));
			assertEquals(1200, Basics.getTotalAsCents(7, 500));
			assertEquals(345, Basics.getTotalAsCents(1, 245));
		}

		@Test
		public void testTotalCentsInvalid() {
			assertEquals(-1, Basics.getTotalAsCents(-3, 25));
			assertEquals(-1, Basics.getTotalAsCents(0, -5));
			assertEquals(-1, Basics.getTotalAsCents(-2, 25));
			assertEquals(-1, Basics.getTotalAsCents(-3, -5));
		}

		@Test
		public void testSumValid() {
			assertEquals(560, Basics.sumAsCents(2, 50, 3, 10));
			assertEquals(822, Basics.sumAsCents(5, 15, 3, 7));
			assertEquals(2340, Basics.sumAsCents(1, 10, 22, 30));
			assertEquals(50, Basics.sumAsCents(0, 20, 0, 30));
			assertEquals(780, Basics.sumAsCents(4, 50, 3, 30));
			assertEquals(1080, Basics.sumAsCents(3, 50, 7, 30));

			assertEquals(749, Basics.sumAsCents(3, 50, 3, 99));
			assertEquals(2600, Basics.sumAsCents(10, 50, 15, 50));
			assertEquals(408, Basics.sumAsCents(2, 10, 0, 198));
			assertEquals(160, Basics.sumAsCents(0, 75, 0, 85));
		}

		@Test
		public void testSumInvalid() {
			assertEquals(-1, Basics.sumAsCents(-3, 50, 3, 99));
			assertEquals(-1, Basics.sumAsCents(10, 50, 15, -50));
			assertEquals(-1, Basics.sumAsCents(2, -10, 0, 98));
			assertEquals(-1, Basics.sumAsCents(0, 75, -1, 185));
			assertEquals(-1, Basics.sumAsCents(0, 75, -5, -85));
		}

		@Test
		public void testSplitValid() {
			assertEquals(280, Basics.splitAsCents(2, 50, 3, 10));
			assertEquals(411, Basics.splitAsCents(5, 15, 3, 7));
			assertEquals(1170, Basics.splitAsCents(1, 10, 22, 30));
			assertEquals(25, Basics.splitAsCents(0, 20, 0, 30));
			assertEquals(390, Basics.splitAsCents(4, 50, 3, 30));
			assertEquals(540, Basics.splitAsCents(3, 50, 7, 30));

			assertEquals(374, Basics.splitAsCents(3, 50, 3, 99));
			assertEquals(1300, Basics.splitAsCents(10, 50, 15, 50));
			assertEquals(204, Basics.splitAsCents(2, 10, 0, 198));
			assertEquals(80, Basics.splitAsCents(0, 75, 0, 85));
		}

		@Test
		public void testSplitInvalid() {
			assertEquals(-1, Basics.splitAsCents(-3, 50, 3, 99));
			assertEquals(-1, Basics.splitAsCents(10, 50, 15, -50));
			assertEquals(-1, Basics.splitAsCents(2, -10, 0, 98));
			assertEquals(-1, Basics.splitAsCents(0, 75, -1, 185));
			assertEquals(-1, Basics.splitAsCents(0, 75, -5, -85));
		}

	}

	@FixMethodOrder(MethodSorters.JVM)
	public static class Task2Test {

		@Test
		public void testConstructor() {
			Money amount = new Money();

			assertEquals(0, amount.getDollars());
			assertEquals(0, amount.getCents());
		}

		@Test
		public void testSimpleMoney() {
			Money amount = new Money(5, 8);
			assertEquals(5, amount.getDollars());
			assertEquals(8, amount.getCents());
			assertEquals(508, amount.getTotalAsCents());
		}

		@Test
		public void testWrappingMoney() {
			Money amount = new Money(5, 215);

			assertEquals(7, amount.getDollars());
			assertEquals(15, amount.getCents());
			assertEquals(715, amount.getTotalAsCents());
		}

		@Test
		public void testIncorrectMoney() {
			Money amount1 = new Money(-1, -1);
			assertEquals(0, amount1.getDollars());
			assertEquals(0, amount1.getCents());
			assertEquals(0, amount1.getTotalAsCents());

			Money amount2 = new Money(-3, 80);
			assertEquals(0, amount2.getDollars());
			assertEquals(80, amount2.getCents());
			assertEquals(80, amount2.getTotalAsCents());

			Money amount3 = new Money(5, -1);
			assertEquals(5, amount3.getDollars());
			assertEquals(0, amount3.getCents());
			assertEquals(500, amount3.getTotalAsCents());

			Money amount4 = new Money(-2, 234);
			assertEquals(2, amount4.getDollars());
			assertEquals(34, amount4.getCents());
			assertEquals(234, amount4.getTotalAsCents());
		}

	}

	@FixMethodOrder(MethodSorters.JVM)
	public static class Task3Test {

		@Test
		public void testAddDollars() {
			Money amount = new Money(6, 80);

			assertEquals(6, amount.getDollars());
			assertEquals(80, amount.getCents());
			assertEquals(680, amount.getTotalAsCents());

			amount.addDollars(3);

			assertEquals(9, amount.getDollars());
			assertEquals(80, amount.getCents());
			assertEquals(980, amount.getTotalAsCents());
		}

		@Test
		public void testAddCents() {
			Money amount = new Money(6, 80);

			assertEquals(6, amount.getDollars());
			assertEquals(80, amount.getCents());
			assertEquals(680, amount.getTotalAsCents());

			amount.addCents(15);

			assertEquals(6, amount.getDollars());
			assertEquals(95, amount.getCents());
			assertEquals(695, amount.getTotalAsCents());

			amount.addCents(25);

			assertEquals(7, amount.getDollars());
			assertEquals(20, amount.getCents());
			assertEquals(720, amount.getTotalAsCents());
		}

		@Test
		public void testAddIgnore() {
			Money amount = new Money(6, 80);

			assertEquals(6, amount.getDollars());
			assertEquals(80, amount.getCents());
			assertEquals(680, amount.getTotalAsCents());

			amount.addDollars(-1);
			assertEquals(6, amount.getDollars());
			assertEquals(80, amount.getCents());
			assertEquals(680, amount.getTotalAsCents());

			amount.addCents(-1);
			assertEquals(6, amount.getDollars());
			assertEquals(80, amount.getCents());
			assertEquals(680, amount.getTotalAsCents());
		}

		@Test
		public void testSubtractDollars() {
			Money amount = new Money(6, 80);

			assertEquals(6, amount.getDollars());
			assertEquals(80, amount.getCents());
			assertEquals(680, amount.getTotalAsCents());

			amount.subtractDollars(3);

			assertEquals(3, amount.getDollars());
			assertEquals(80, amount.getCents());
			assertEquals(380, amount.getTotalAsCents());
		}

		@Test
		public void testSubtractCents() {
			Money amount = new Money(6, 80);

			assertEquals(6, amount.getDollars());
			assertEquals(80, amount.getCents());
			assertEquals(680, amount.getTotalAsCents());

			amount.subtractCents(15);

			assertEquals(6, amount.getDollars());
			assertEquals(65, amount.getCents());
			assertEquals(665, amount.getTotalAsCents());

			amount.subtractCents(75);

			assertEquals(5, amount.getDollars());
			assertEquals(90, amount.getCents());
			assertEquals(590, amount.getTotalAsCents());
		}

		@Test
		public void testSubtractIgnore() {
			Money amount = new Money(6, 80);

			assertEquals(6, amount.getDollars());
			assertEquals(80, amount.getCents());
			assertEquals(680, amount.getTotalAsCents());

			amount.subtractDollars(-1);
			assertEquals(6, amount.getDollars());
			assertEquals(80, amount.getCents());
			assertEquals(680, amount.getTotalAsCents());

			amount.subtractCents(-1);
			assertEquals(6, amount.getDollars());
			assertEquals(80, amount.getCents());
			assertEquals(680, amount.getTotalAsCents());
		}
	}

	@FixMethodOrder(MethodSorters.JVM)
	public static class Task4Test {

		@Test
		public void testAddMoney() {
			Money amount1 = new Money(5, 20);
			Money amount2 = new Money(3, 30);

			assertEquals(520, amount1.getTotalAsCents());
			assertEquals(330, amount2.getTotalAsCents());

			amount1.add(amount2);
			assertEquals(850, amount1.getTotalAsCents());
			assertEquals(330, amount2.getTotalAsCents());

			Money amount3 = new Money(1, 280);
			assertEquals(380, amount3.getTotalAsCents());

			amount1.add(amount3);
			assertEquals(1230, amount1.getTotalAsCents());
			assertEquals(330, amount2.getTotalAsCents());
			assertEquals(380, amount3.getTotalAsCents());
		}

		@Test
		public void testSubtractMoney() {
			Money amount1 = new Money(8, 20);
			Money amount2 = new Money(3, 10);

			assertEquals(820, amount1.getTotalAsCents());
			assertEquals(310, amount2.getTotalAsCents());

			amount1.subtract(amount2);
			assertEquals(510, amount1.getTotalAsCents());
			assertEquals(310, amount2.getTotalAsCents());

			Money amount3 = new Money(1, 180);
			assertEquals(280, amount3.getTotalAsCents());

			amount1.subtract(amount3);
			assertEquals(230, amount1.getTotalAsCents());
			assertEquals(310, amount2.getTotalAsCents());
			assertEquals(280, amount3.getTotalAsCents());
		}

		@Test
		public void testSubtractMoneyIgnore() {
			Money amount1 = new Money(8, 20);
			Money amount2 = new Money(7, 200);

			assertEquals(820, amount1.getTotalAsCents());
			assertEquals(900, amount2.getTotalAsCents());

			amount1.subtract(amount2);
			assertEquals(820, amount1.getTotalAsCents());
			assertEquals(900, amount2.getTotalAsCents());
		}

		@Test
		public void testSplitMoney() {
			Money amount1 = new Money(8, 20);
			Money amount2 = new Money(3, 10);

			amount1.split(amount2);

			assertEquals(5, amount1.getDollars());
			assertEquals(65, amount1.getCents());
			assertEquals(565, amount1.getTotalAsCents());

			assertEquals(5, amount2.getDollars());
			assertEquals(65, amount2.getCents());
			assertEquals(565, amount2.getTotalAsCents());

			Money amount3 = new Money();
			amount2.split(amount3);

			assertEquals(5, amount1.getDollars());
			assertEquals(65, amount1.getCents());
			assertEquals(565, amount1.getTotalAsCents());

			assertEquals(2, amount2.getDollars());
			assertEquals(82, amount2.getCents());
			assertEquals(282, amount2.getTotalAsCents());

			assertEquals(2, amount3.getDollars());
			assertEquals(82, amount3.getCents());
			assertEquals(282, amount3.getTotalAsCents());
		}
	}

	/**
	 * (Facultative) you can write your test cases here there tests are only for you
	 * will not be used for marking the assignment
	 * 
	 */
	public static class YourTests {

		@Test
		public void test1() {
			Money amount = new Money(6, 80);

			assertEquals(6, amount.getDollars());
			assertEquals(80, amount.getCents());
			assertEquals(680, amount.getTotalAsCents());

			amount.subtractCents(15);

			assertEquals(6, amount.getDollars());
			assertEquals(65, amount.getCents());
			assertEquals(665, amount.getTotalAsCents());

			amount.subtractCents(125);

			assertEquals(5, amount.getDollars());
			assertEquals(40, amount.getCents());
			assertEquals(540, amount.getTotalAsCents());
		}

	}
}
