package Thread.university.maryland.Programming_Language_Technologies_and_Paradigms.lect2;

/**
 * Class using Runnable interface to help implement
 * threads printing "Hello World!"
 *  
 * @author rance
 *
 */
public class HelloWorldRunnable implements Runnable {
	public void run () {
		System.out.println ("Runnable says Hello World!");
	}
}
