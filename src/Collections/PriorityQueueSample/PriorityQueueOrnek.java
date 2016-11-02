package Collections.PriorityQueueSample;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Created by cnkaptan on 29/10/16.
 */
public class PriorityQueueOrnek {

    public static void main(String[] args) {
        // Comparator ile PriorityQueue örneği
        Queue<Musteri> musteriPriorityQueue = new PriorityQueue<>(5, new Comparator<Musteri>() {
            @Override
            public int compare(Musteri o1, Musteri o2) {
                return o1.getId() - o2.getId();
            }
        });
        addDataToQueue(musteriPriorityQueue);
        pollDataFromQueue(musteriPriorityQueue);
    }


    // Queue'ye random data ekleme
    private static void addDataToQueue(Queue<Musteri> musteriPriorityQueue) {
        Random rand = new Random();
        for ( int i = 0 ; i < 5 ; i++ ) {
            int id = rand.nextInt(100);
            musteriPriorityQueue.add(new Musteri(id, "İsim" + id));
        }
    }

    // Queue'den random data çekme
    private static void pollDataFromQueue(Queue<Musteri> musteriPriorityQueue) {
        while (true) {
            Musteri musteri = musteriPriorityQueue.poll();
            if ( musteri == null )
                break;
            System.out.println("Müşteri = " + musteri.getId() + " - " + musteri.getIsim());
        }
    }
}
