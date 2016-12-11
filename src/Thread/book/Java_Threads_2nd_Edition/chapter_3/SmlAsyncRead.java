package Thread.book.Java_Threads_2nd_Edition.chapter_3;

/**
 * Created by cihankaptan on 04/11/16.
 */
public class SmlAsyncRead extends Thread {
    private char value = 'c';
    private StringBuffer result;

    public SmlAsyncRead() {
        result = new StringBuffer();
    }

    public void run() {
        while (true) {
            try {
                appendResult(value);
            } catch (Exception e) {

            }
        }
    }

    // Get the string already read from the socket so far.
    // This method is used by the Applet thread to obtain the data
    // in a synchronous manner.
    public synchronized String getResult() {
        String retval = result.toString();
        result = new StringBuffer();
        System.out.println(retval);
        return retval;
    }

    // Put new data into the buffer to be returned
    // by the getResult method
    public synchronized void appendResult(char c) {
        result.append(c);
        System.out.println(result.toString());
    }
}
