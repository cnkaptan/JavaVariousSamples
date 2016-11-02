package Thread.university.maryland.Programming_Language_Technologies_and_Paradigms.lect2;

/**
 * Class of threads for printing "Hello World", implemented using inheritance.
 * 
 * @author rance
 *
 */
public class HelloWorldThread extends Thread {
	public void run () {
		System.out.println (Thread.currentThread() + " prints:  Thread says Hello World!");
	}
}
