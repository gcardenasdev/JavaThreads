package threads;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class multiThreadTest {

	@Test
	void test() {
		
		
		int[] arr = {2, 2, 2, 2, 2};
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		System.out.println("Sum of test " + sum);
		assertEquals(sum, arraySumMulti.multiThread(arr));
	}

}
