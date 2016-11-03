package Thread.book.Java_Threads_2nd_Edition.chapter_2;

/**
 * Created by cihankaptan on 03/11/16.
 */
public class IsciRunnable implements Runnable {
    private String name;

    public IsciRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " basliyor");
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