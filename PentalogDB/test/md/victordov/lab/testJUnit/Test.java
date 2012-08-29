package md.victordov.lab.testJUnit;

import static org.junit.Assert.*;
import md.victordov.lab.common.other.HasNumber;

public class Test {

	@org.junit.Test
	public void testHasNumber() {
		String numbersLetters = "Abcd1234";
		assertTrue(HasNumber.hasNumber(numbersLetters));
	}
}
