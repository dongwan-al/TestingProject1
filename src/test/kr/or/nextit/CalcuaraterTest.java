package kr.or.nextit;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcuaraterTest {

	@Test
	public void testSum() {
		double result = Calcuarater.sum(4,5);
		assertTrue("9가 나와야함",result == 9);
		
	}

	@Test
	public void testSubtract() {
		double result = Calcuarater.subtract(5,1);
		assertTrue("4가 나와야함",result == 4);
	}

	@Test
	public void testMultiply() {
		double result = Calcuarater.multiply(4, 5);
		assertTrue("20 나와야함",result == 20);
	}

	@Test
	public void testDivide() {
		double result = Calcuarater.divide(4, 2);
		assertTrue("2가 나와야함",result == 2);
	}

}
