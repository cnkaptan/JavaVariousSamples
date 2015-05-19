package Thread;

/**
 * Created by cnkaptan on 5/8/15.
 */
public class JoinSample {
    public static void main(String[] args){
        System.out.println("Main thread calismaya basladi");
        Thread thread = new Thread(new IsciRunnable());
        thread.start();

        try
        {
            // Main threadte de belli bir islem oldugunu simule etmek icin onuda iki saniye uyutalim
            Thread.sleep(2000);
        }
        catch (InterruptedException ie)
        {
        }

        System.out.println("Main Thread islemini bitirdi");
        System.out.println("Main Thread isci Thread'in islemlerinin bitmesini bekliyor");


        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main Thread oluyor");
    }
}


class IsciRunnable implements Runnable{

    @Override
    public void run() {
        //Isci Thread ,belli bir islem yapildigini simule etmek icin threadi 5 saniye bekletiyoruz"
        try
        {
            Thread.sleep(5000);
        }catch (InterruptedException e){

        }
        System.out.println("Isci Thread oluyor.");
    }
}