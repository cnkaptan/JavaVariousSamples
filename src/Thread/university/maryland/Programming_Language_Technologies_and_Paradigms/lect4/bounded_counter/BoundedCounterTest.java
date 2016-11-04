package Thread.university.maryland.Programming_Language_Technologies_and_Paradigms.lect4.bounded_counter;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


/**
 * Test showing possibility of race condition in non-thread-safe bounded counter objects.
 * 
 * @author Rance Cleaveland
 *
 */
public class BoundedCounterTest {

	@Test
	public void test() {
		int numThreads = 500;	// Number of threads simultaneously accessing counter
		BoundedCounter shared = new BoundedCounter(numThreads);
		Thread[] t = new Thread[numThreads];
		int numRuns = 20;		// Number of trials of test
		for (int i = 0; i < numRuns; i++) {
			shared.reset(); // Reset counter to 0
			// Create threads
			for (int j = 0; j < numThreads; j++) {
				t[j] = new BoundedCounterUserThread (Integer.toString(j), shared);
			}
			// Start threads
			for (int j = 0; j < numThreads; j++) {
				t[j].start();
			}
			// Wait for thread termination
			for (int j=0; j < numThreads; j++) {
				try {
					t[j].join();
				}
				catch (InterruptedException e) { }
			}
			System.out.println ("Number of increments:  " + numThreads + "; Counter value = " + shared.current());
			// Assert that value of counter == # of threads (so, no lost increments)
			assertTrue("foo", (shared.current()) == numThreads);
		}
	}

}
