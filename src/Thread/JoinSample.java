package Thread;

/**
 * Created by cnkaptan on 5/8/15.
 */
public class JoinSample {
    public static void main(String[] args) {
        System.out.println("Main thread calismaya basladi");
        Thread thread1 = new Thread(new IsciRunnable("Thread 1"));
        Thread thread2 = new Thread(new IsciRunnable("Thread 2"));
        thread1.start();

        try {
            // Main threadte de belli bir islem oldugunu simule etmek icin onuda iki saniye uyutalim
            Thread.sleep(2000);
        } catch (InterruptedException ie) {
        }

        System.out.println("Main Thread uykudan uyandi");

        try {
            thread1.join();
            thread2.start();
            thread2.join();
            System.out.println("Isci Threadler islemlerini bitirdi");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main Thread oluyor");
    }
}


class IsciRunnable implements Runnable {
    private String name;

    public IsciRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name+" basliyor");
        //Isci Thread ,belli bir islem yapildigini simule etmek icin threadi 5 saniye bekletiyoruz"
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(name + "\t" + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
        System.out.println(name + " oluyor.");
    }
}