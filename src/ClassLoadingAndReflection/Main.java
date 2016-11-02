package ClassLoadingAndReflection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cnkaptan on 20/06/16.
 */
public class Main {

    public static void main(String[] args){
        Main main = new Main();
        Class<?> c = main.getClass();
        System.out.println(c);
        c = Main.class;
        System.out.println(c);
        // Express a class literal as a type name followed by ".class"
        c = int.class; // Same as Integer.TYPE
        System.out.println(c);
        c = String.class; // Same as "a string".getClass()
        System.out.println(c);
        c = byte[].class; // Type of byte arrays
        System.out.println(c);

        for (int i = 0; i<100;i++){
            System.out.print("-");
            if (i==99){
                System.out.println();
            }
        }

        // Obtain a Class object for primitive types with various
        // predefined constants
        c = Void.TYPE; // The special "no-return-value" type
        System.out.println(c);
        c = Byte.TYPE; // Class object that represents a byte
        System.out.println(c);
        c = Integer.TYPE; // Class object that represents an int
        System.out.println(c);
        c = Double.TYPE; // etc; see also Short, Character, Long, Float
        System.out.println(c);


        System.out.println(commonAncestor(Integer.class,Double.class));
    }



    public static Class<?> commonAncestor(Class<?> cl1,Class<?> cl2){
        if (cl1 == null || cl2 == null) return null;
        if (cl1.equals(cl2)) return cl1;
        if (cl1.isPrimitive()||cl2.isPrimitive()) return null;

        List<Class<?>> ancestors = new ArrayList<>();
        Class<?> c = cl1;

        while(!c.equals(Object.class)){
            if (c.equals(cl2)) return c;
            ancestors.add(c);
            c = c.getSuperclass();
        }

        c = cl2;
        while (!c.equals(Object.class)){
            for (Class<?> k : ancestors){
                if (c.equals(k)) return c;

            }
            c = c.getSuperclass();
        }

        return Object.class;
    }


}
