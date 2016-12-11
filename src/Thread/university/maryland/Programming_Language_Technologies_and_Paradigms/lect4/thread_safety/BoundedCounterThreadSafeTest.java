package Thread.university.maryland.Programming_Language_Technologies_and_Paradigms.lect4.thread_safety;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BoundedCounterThreadSafeTest {

	@Test
	public void test() {
		int numThreads = 500;
		BoundedCounterThreadSafe shared = new BoundedCounterThreadSafe (numThreads);
		Thread[] t = new Thread[numThreads];
		int numRuns = 10;
		for (int i = 0; i < numRuns; i++) {
			shared.reset();
			for (int j = 0; j < numThreads; j++) {
				t[j] = new BoundedCounterThreadSafeUserThread (Integer.toString(j), shared);
			}
			for (int j = 0; j < numThreads; j++) {
				t[j].start();
			}
			for (int j=0; j < numThreads; j++) {
				try {
					t[j].join();
				}
				catch (InterruptedException e) { }
			}
			System.out.println ("Number of increments:  " + numThreads + "; Counter value = " + shared.current());
			assertTrue("Thread-safety", (shared.current()) == numThreads);
		}
	}
}
