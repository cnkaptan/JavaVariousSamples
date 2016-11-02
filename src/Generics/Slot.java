package Generics;

/**
 * Created by cnkaptan on 29/02/16.
 */
public class Slot<T> {
    private T key;

    public T getValue() {
        return key;
    }

    public void setValue(T key) {
        this.key = key;
    }

    public static void main(String[] args){
        Slot<String> string = new Slot<String>();
        string.setValue(":)");

        System.out.println(string.getValue());

        Slot<Integer> num = new Slot<Integer>();
        num.setValue(5);

        System.out.println(num.getValue());
    }
}
