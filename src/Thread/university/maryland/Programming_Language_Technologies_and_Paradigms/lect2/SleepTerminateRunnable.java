package Thread.university.maryland.Programming_Language_Technologies_and_Paradigms.lect2;

public class SleepTerminateRunnable implements Runnable {
	public void run () {
		try {
			Thread.sleep (2000);
		}
		catch (InterruptedException e) {
			System.out.println ("InterruptedException caught");
		}
//		finally {System.out.println ("Caught by finally");}
		System.out.println ("Thread finishing ...");
	}
}
