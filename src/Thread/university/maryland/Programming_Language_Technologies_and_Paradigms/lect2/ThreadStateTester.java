package Thread.university.maryland.Programming_Language_Technologies_and_Paradigms.lect2;

/**
 * Test various thread operations
 * 
 * @author Rance Cleaveland
 *
 */
public class ThreadStateTester {

	public static void printState (Thread t){
		System.out.println ("Thread state of " + t.getName() + " is:  " + t.getState());
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread ();
		printState (t);
		t.start ();
		printState (t);
		t.join ();
		printState(Thread.currentThread());
		t.join();
		printState (t);
	}

}
