package Thread;

/**
 * Created by cnkaptan on 5/19/15.
 */
public class BasicSync {
    static int sayac = 0;
    static Runnable run = new Runnable() {
        @Override
        public void run() {
            arttir();
        }
    };

    private synchronized static void arttir() {
        for (int i = 0; i < 2000000; i++)
        {
            sayac++;
        }
    }

    public static void main(String[] args)
        {
            // Thread objeleri run runnable ni alarak yaratildi
            Thread thread1 = new Thread(run,"Thread 1");
            Thread thread2 = new Thread(run,"Thread 2");

            // threadler baslatildi
            thread1.start();
            thread2.start();


            try {
                // Bu iki threadi main join yaparak
                // main threadin onlar bitene kadar beklemesini sagladik
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Surec Bitti...");
            System.out.println(sayac);
        }

}
