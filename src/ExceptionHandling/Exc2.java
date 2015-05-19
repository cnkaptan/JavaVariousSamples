package ExceptionHandling;

/**
 * Created by cnkaptan on 4/24/15.
 */
class Exc2 {
    public static void main(String args[]) {
        int d, a;
        try { // monitor a block of code.
            d = 0;
            a = 42 / d;
            System.out.println("This will not be printed.");
        } catch (ArithmeticException e) { // catch divide-by-zero error
            System.out.println("Division by zero.");
        }finally {
            System.out.println("in finally Block");
        }
        System.out.println("After catch statement.");
    }
}