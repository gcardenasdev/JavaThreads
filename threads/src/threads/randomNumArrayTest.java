package threads;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class randomNumArrayTest {

	@Test
	void test() {
		arraySum testarray = new arraySum();
		
		assertFalse(testarray.randomNumberArray().length == 0);
	}
	
	@Test
	void test2() {
		arraySum testarray = new arraySum();
		
		assertTrue(testarray.randomNumberArray().length == 200000000);
	}

}
