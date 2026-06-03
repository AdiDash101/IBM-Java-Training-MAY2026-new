package day7;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class MathTest {

	private static final float DELTA = 0.0001f;
	
	@Test
	public void testAdd() {
		assertEquals(5.5f, BasicMath.add(2.2f, 3.3f), DELTA);
		assertEquals(-1.0f, BasicMath.add(2.0f, -3.0f), DELTA);
	}
	
	public void testSubstract() {
		assertEquals(1.5f, BasicMath.substract(4.0f, 2.5f), DELTA);
		assertEquals(5.0f, BasicMath.substract(2.0f, -3.0f), DELTA);
	}
	
	@Test 
	public void testMultiply() {
		assertEquals(6.0f, BasicMath.multiply(2.0f, 3.0f), DELTA);
		assertEquals(0.0f, BasicMath.multiply(5.5f, 0.0f), DELTA);
	}
	
	public void testDivide() {
		assertEquals(2.0f, BasicMath.divide(5.0f, 2.5f), DELTA);
		assertEquals(-3.0f, BasicMath.divide(9.0f, -3.0f), DELTA);
	}

	@Test
	public void testDivideByZeroThrowsException() {
		Exception exception = assertThrows(ArithmeticException.class, () -> {
			BasicMath.divide(10.0f, 0.0f);
		});
		
		assertEquals("Cannot divide by zero. ", exception.getMessage());
		
		
	}

}
