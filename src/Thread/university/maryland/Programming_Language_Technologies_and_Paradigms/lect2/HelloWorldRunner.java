package Thread.university.maryland.Programming_Language_Technologies_and_Paradigms.lect2;

/**
 * Simple hello world program, using threads.
 * 
 * @author rance
 *
 */
public class HelloWorldRunner {

	public static void main(String[] args) throws InterruptedException {
		Thread h1 = new HelloWorldThread ();
		Thread h2 = new Thread (new HelloWorldRunnable ());
		System.out.println("h1 thread state is " + h1.getState());
		h1.start();
		System.out.println("h1 thread state is " + h1.getState());
//		h1.start();
//		h1.run();
//		h2.start ();
//		try {
//			Thread.sleep (100);
//		}
//		catch (InterruptedException e) {}
		h1.join();
		h1.run();
		System.out.println ("h1 thread state is " + h1.getState());
//		h2.run();
	}
}
