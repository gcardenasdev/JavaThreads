package threads;

import java.util.Arrays;
import java.util.Random;

public class arraySumMulti {

	static int sumOfArray = 0;
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		
		multiThread(randomNumberArray());
		
		long totalTime = System.nanoTime() - startTime;
		System.out.println("\n" + "Total duration in nanoseconds: " + totalTime);

	}
	
public static int[] randomNumberArray() {
		
		int arr[] = new int[200000000];
		Random random = new Random();
	

		for(int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(10 - 1 + 1) + 1;
		}
		
		return arr;
	}

public static synchronized void sum(int[] arr) {
	
	for(int i = 0; i < arr.length; i++) {
		sumOfArray = sumOfArray + arr[i];
	}
	
}

public static int multiThread(int[] arr) {
	
	int[] arr1 = Arrays.copyOfRange(arr, 0, arr.length/2);
	int[] arr2 = Arrays.copyOfRange(arr, arr.length/2, arr.length);
	
	Thread t1 = new Thread(new Runnable() {
		@Override
		public void run() {
			sum(arr1);	
		}
	});
	
	Thread t2 = new Thread(new Runnable() {
		@Override
		public void run() {
			
			sum(arr2);
			
		}
	});
	
	t1.start();
	t2.start();
	
	try {
		t1.join();
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("Sum of joined array is: " + sumOfArray);
	return sumOfArray;
	
}


}
