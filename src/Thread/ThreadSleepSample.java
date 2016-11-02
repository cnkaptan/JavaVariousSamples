package Thread;

/**
 * Created by cnkaptan on 29/10/16.
 */
public class ThreadSleepSample {

    public static void main(String[] args) {
        String importantInfo[] = {"Mares eat oats", "Does eat oats", "Little lambs eat ivy", "A kid will eat ivy too"};

        for (int i = 0; i < importantInfo.length; i++) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

            System.out.println(importantInfo[i]);
        }
    }
}
