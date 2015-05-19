package Thread;

/**
 * Created by cnkaptan on 5/8/15.
 */
public class SleepSample {
    public static void main(String[] args){

        //Thread Olusturuldugu sirada ayni zamanda baslatildi
        MyThread thread = new MyThread("MyThread");

        for(int i=0; i < 50; i++) {
            System.out.print(" . ");
            try {
                Thread.sleep(100);
            }
            catch(InterruptedException exc) {
                System.out.println("Main thread yarida kesildi.");
            }
        }
        System.out.println("Main thread sonlandiriliyor.");
    }
}


class MyThread implements Runnable {
    Thread thrd;

    MyThread(String name) {
        // Baska Bir Thread Constructor Thread(Runnable run,String name)
        thrd = new Thread(this, name);  //Threadi yarattik

        thrd.start(); // Threadi baslattik
    }

    public void run() {
        System.out.println(thrd.getName() + " basliyor.");
        try {
            for(int i=0; i<10; i++) {

                // Icinde bulunulan Thredi 400 milisaniye askiya aliyor
                Thread.sleep(400);

                System.out.println(thrd.getName() + ", i = " + i);
            }
        }
        catch(InterruptedException exc) {
            System.out.println(thrd.getName() + " yarida kesildi.");
        }

        System.out.println(thrd.getName() + " sonlandiriliyor.");
    }
}
