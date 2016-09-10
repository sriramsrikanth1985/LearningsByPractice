import static org.junit.Assert.*;

import org.junit.Test;


public class HelloWorldTest {
	
	HelloWorld tester = new HelloWorld();

	@Test
	public void testMultiply() {
		assertEquals("10 x 0 must be 0", 0, tester.multiply(10, 0));
		   assertEquals("0 x 10 must be 0", 0, tester.multiply(0, 10));
		   assertEquals("0 x 0 must be 0", 0, tester.multiply(0, 0));
		   assertEquals("2 x 2 must be 4", 4, tester.multiply(0, 0));
	}

}
