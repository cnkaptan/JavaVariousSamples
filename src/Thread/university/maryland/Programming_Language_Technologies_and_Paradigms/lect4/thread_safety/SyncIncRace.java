package Thread.university.maryland.Programming_Language_Technologies_and_Paradigms.lect4.thread_safety;

/**
 * Correctly synchronized version of "IncRace" example
 * 
 * @author Rance Cleaveland
 *
 */
public class SyncIncRace {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread (new SyncIncThread ("t1"));
		Thread t2 = new Thread (new SyncIncThread ("t2"));
		t1.start ();
//		Thread.sleep (10);
		t2.start ();
	}

}
