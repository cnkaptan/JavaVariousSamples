package Thread.university.maryland.Programming_Language_Technologies_and_Paradigms.lect4.thread_safety;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * JUnit test to show correctly synchronized IncThread class
 * 
 * @author Rance Cleaveland
 *
 */
public class TestRace {

	private int numRuns = 100; // Number of times to repeat execution
	
	// Test to illustrate interleaving issues when there is a data race
	@Test
	public void test() throws InterruptedException {
		int passes = 0;  // Number of times correct number of increments occurs
		for (int i=0; i < numRuns; i++) {
			System.out.println ("\nRun "+i);
			System.out.println (  "-----");
			SyncIncThread.resetShared();
			Thread t1 = new Thread (new SyncIncThread ("t1"));
			Thread t2 = new Thread (new SyncIncThread ("t2"));
			t1.start();
			t2.start();
			t1.join();  // Wait for t1 to finish
			t2.join();  // Wait for t2 to finish
			passes = (SyncIncThread.getShared() == 2) ? (passes + 1) : passes;
		}
		System.out.println ("\n------------------------------\n");
		System.out.println ("# of runs = " + numRuns + "; # of passes = " + passes);
		assertTrue(passes == numRuns);
	}

}
