package Thread.university.maryland.Programming_Language_Technologies_and_Paradigms.lect2;

/**
 * Test program for isAlive(), join(), daemon status
 * 
 * @author rance
 *
 */
public class TerminateTester {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread (new SleepTerminateRunnable ());
		System.out.println ("alive value for t is:  " + t.isAlive ());
//		t.setDaemon (true);
		t.start ();
//		t.setDaemon (true);
		System.out.println ("alive value for t is:  " + t.isAlive ());	
//		t.interrupt();
//		t.join();
//		t.setDaemon(true);
		t.run();
		System.out.println ("Main finishing ...");
	}

}
