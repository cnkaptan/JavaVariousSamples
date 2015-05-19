package DefaultInterface;

/**
 * Created by cnkaptan on 4/24/15.
 */
interface MyIF {

    int getNumber();

    default String getString() {
        return "Default String";
    }
}

class MyIfImp implements MyIF{

    @Override
    public int getNumber() {
        return 20;
    }

    @Override
    public String getString() {
        return "duzenlenmis";
    }

    public static void main(String[] args){
        System.out.println(new MyIfImp().getNumber());
        System.out.println(new MyIfImp().getString());
    }


}