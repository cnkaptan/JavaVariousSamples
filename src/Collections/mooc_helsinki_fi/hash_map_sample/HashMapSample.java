package Collections.mooc_helsinki_fi.hash_map_sample;

import java.util.HashMap;

/**
 * Created by cihankaptan on 27/10/16.
 */
public class HashMapSample {

    /**
     * HashMap is one of Java's most useful data structures.
     * The idea behind HashMap is we define an index for an object key - a unique value, for instance a social security number,
     * a student number, or a phone number. We call hashing the process of changing a key into an index or simply to define an index.
     * The hashing happens thanks to a particular function which makes sure that we get always the same index with a known key.
     * Adding and retrieving items based on the keys allows for a particularly quick search process.
     * Instead of parsing the table items one by one (in the worst case we would have to go through all the items),
     * and instead of looking for a value with a binary search
     * (in which case we would have to go through a number of items which would depend on the logarithm of the table size),
     * we can look at only one table index and check whether a value is mapped to that index.
     */

    public static void main(String[] args){
        HashMap<String, String> numbers = new HashMap<>();
        numbers.put("One", "Yksi");
        numbers.put("Two", "Kaksi");

        String translation = numbers.get("One");
        System.out.println(translation);

        System.out.println(numbers.get("Two"));
        System.out.println(numbers.get("Three"));
        System.out.println(numbers.get("Yksi"));

        numbers.put("One", "Uno");
        System.out.println(numbers.get("One"));


        System.out.println("-----------------------------------------------------------------------------------------");

        HashMap<String, Book> bookCollection = new HashMap<>();

        Book senseAndSensibility = new Book("Sense and Sensibility", 1811, "...");
        Book prideAndPrejudice = new Book("Pride and Prejudice", 1813, "....");
        bookCollection.put(senseAndSensibility.getName(),senseAndSensibility);
        bookCollection.put(prideAndPrejudice.getName(),prideAndPrejudice);

        Book book = bookCollection.get("Persuasion");
        System.out.println(book);
        System.out.println();
        book = bookCollection.get("Pride and Prejudice");
        System.out.println(book);
    }
}
