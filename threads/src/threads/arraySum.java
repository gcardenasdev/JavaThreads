package threads;
import java.util.Random;

public class arraySum {
	
	static int sumOfArray = 0;
	
	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		
		singleThread(randomNumberArray());
		
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


public static int singleThread(int[] arr) {
	
	Thread t1 = new Thread (new Runnable() {

		@Override
		public void run() {
			
			sum(arr);
		}
	});
	
	t1.start();
	
	try {
		t1.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("Sum of single thread Array: " + sumOfArray);
	return sumOfArray;
	
}


}
