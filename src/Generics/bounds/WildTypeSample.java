package Generics.bounds;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by cnkaptan on 29/10/16.
 */
public class WildTypeSample {

    public static void main(String[] args){
        List<String> c = new ArrayList<String>();
        c.add("elma");
        c.add("armut");
        printCollection(c);
        List<Integer> i = new ArrayList<Integer>();
        i.add(1);
        i.add(2);
        printCollection(i);
    }


    public static void printCollection(Collection<?> collection){

//        for (Object o : collection) {
//            System.out.println(o);
//        }

        Iterator<?> iterator = collection.iterator();
        for (int i = 0; i < collection.size(); i++) {

            System.out.println(iterator.next());
        }
    }
}
