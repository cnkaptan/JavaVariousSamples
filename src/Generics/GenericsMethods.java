package Generics;

/**
 * Created by cnkaptan on 29/10/16.
 */
public class GenericsMethods {

    public static void main(String args[]){
        Generic<String> tip= new Generic<String>();
        tip.setType("Elif"); //geçerli
        Generic tip1= new Generic(); //işlenmemiş tip
        tip1.setType("Elif"); //geçerli
        tip1.setType(10); //geçerli ve autoboxing desteği
    }

    public static class Generic<T>{
        private T type;

        public T getType() {
            return type;
        }

        public void setType(T type) {
            this.type = type;
        }
    }
}
