package prac3;

import org.junit.Assert;
import org.junit.Test;

/** Some JUnit tests for the Polynomial class. */
public class PolynomialTest {

	/** Test the zero constructor of Polynomial. */
	@Test
	public void testInitialStateZeroPolynomial() {
		Polynomial p = new Polynomial();
		Assert.assertEquals("0", p.toString());
		Assert.assertTrue("Invariant check failed", p.checkInvariant());
	}

	/** Test the monomial constructor of Polynomial. */
	@Test
	public void testInitialStateMonomial() {

		// check initial state of monomial with a zero exponent
		Polynomial p = new Polynomial(3, 0);
		Assert.assertEquals("3", p.toString());
		Assert.assertTrue("Invariant check failed", p.checkInvariant());

		// check initial state of monomial with an exponent of one
		p = new Polynomial(3, 1);
		Assert.assertEquals("3x", p.toString());
		Assert.assertTrue("Invariant check failed", p.checkInvariant());

		// check initial state of monomial with a typical exponent greater than
		// one
		p = new Polynomial(3, 4);
		Assert.assertEquals("3x^4", p.toString());
		Assert.assertTrue("Invariant check failed", p.checkInvariant());

		// check initial state of monomial with a typical exponent and negative
		// coefficient
		p = new Polynomial(-3, 4);
		Assert.assertEquals("-3x^4", p.toString());
		Assert.assertTrue("Invariant check failed", p.checkInvariant());

		// check initial state of monomial with a typical exponent and zero
		// coefficient
		p = new Polynomial(0, 4);
		Assert.assertEquals("0", p.toString());
		Assert.assertTrue("Invariant check failed", p.checkInvariant());
	}

	/**
	 * Test that attempting to create a monomial with a negative exponent
	 * results in a NegativeExponentException
	 **/
	@Test(expected = NegativeExponentException.class)
	public void testNegativeExponent() {
		@SuppressWarnings("unused")
		Polynomial p = new Polynomial(3, -1);
	}

	/** Test additions of monomials. **/
	@Test
	public void testAdditionOfMonomials() {

		// test addition of monomials where the result has two terms
		Polynomial p1 = new Polynomial(4, 5);
		Polynomial p2 = new Polynomial(2, 3);
		Polynomial actual = p1.add(p2);
		Assert.assertEquals("4x^5 + 2x^3", actual.toString());
		Assert.assertTrue("Invariant check failed", actual.checkInvariant());

		// test addition of monomials where the result is also a monomial
		p1 = new Polynomial(4, 5);
		p2 = new Polynomial(2, 5);
		actual = p1.add(p2);
		Assert.assertEquals("6x^5", actual.toString());
		Assert.assertTrue("Invariant check failed", actual.checkInvariant());

		// test addition of monomials where the answer is the zero polynomial
		p1 = new Polynomial(-4, 2);
		p2 = new Polynomial(4, 2);
		actual = p1.add(p2);
		Assert.assertEquals("0", actual.toString());
		Assert.assertTrue("Invariant check failed", actual.checkInvariant());

		// test addition of a monomial with the zero polynomial
		p1 = new Polynomial();
		p2 = new Polynomial(4, 2);
		actual = p1.add(p2);
		Assert.assertEquals("4x^2", actual.toString());
		Assert.assertTrue("Invariant check failed", actual.checkInvariant());
	}

	/** Test additions of polynomials with many terms. **/
	@Test
	public void testAdditionOfTypicalPolynomials() {
		// test multiple typical additions (that produce polynomials with many
		// terms)
		Polynomial p1 = new Polynomial(-2, 5); // -2x^5
		Polynomial p2 = new Polynomial(3, 1); // 3x
		Polynomial p3 = new Polynomial(6, 2); // 6x^2
		Polynomial p4 = new Polynomial(2, 0); // 2
		Polynomial p5 = new Polynomial(1, 2); // 1x^2
		Polynomial p6 = new Polynomial(5, 8); // 5x^8

		Polynomial actual = p1.add(p2.add(p3.add(p4))).add(p5.add(p6));
		Assert.assertEquals("5x^8 + -2x^5 + 7x^2 + 3x + 2", actual.toString());
		Assert.assertTrue("Invariant check failed", actual.checkInvariant());
	}

}
