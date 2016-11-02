package Thread.book.Java_Threads_2nd_Edition.chapter_2;

import java.awt.*;

/**
 * Created by cihankaptan on 01/11/16.
 */
public class TimerThread extends Thread {
    private Component component;            // Component that needs repainting
    private int timediff;                   // Time between repaints of the component
    private volatile boolean shouldRun;     // Set to false to stop thread


    public TimerThread(Component component, int timediff) {
        this.component = component;
        this.timediff = timediff;
        this.shouldRun = true;
    }

    @Override
    public void run() {

        while (shouldRun){
            try{
                component.repaint();
                sleep(timediff);
            }catch (Exception ex){

            }
        }

    }
}
