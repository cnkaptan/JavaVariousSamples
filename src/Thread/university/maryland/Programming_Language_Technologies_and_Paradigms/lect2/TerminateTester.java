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
        System.out.println ("alive value for t is:  " + t.isAlive ()+"\t Thread state "+t.getState());
//		t.setDaemon (true); // sadece state new iken cagirilir , bir thread daemon ise proces onun bitmesini beklemez.
//      her thread default olarak user thread olarak set edilir daemon = false
		t.start ();
//		t.setDaemon (true); // start'tan sonra cagirirsan IllegalThreadStateException hatasi alirsin
		System.out.println ("alive value for t is:  " + t.isAlive ()+"\t Thread state "+t.getState());
//		t.interrupt();
//		t.join();
//		t.run();
		System.out.println ("Main finishing ...");
	}

}
