package Generics.bounds;

import Generics.bounds.shapes.Circle;
import Generics.bounds.shapes.Rectangle;
import Generics.bounds.shapes.Shape;
import Generics.bounds.shapes.Square;

import java.util.List;

/**
 * Created by cnkaptan on 11/12/2016.
 */
public class UpperAndLowerBounds {
    public static void main(String[] args) {

    }

    /**
     * Example for an upper bound wildcard
     * We can not safely add, because we may have  `List<Circle>`, `List<Square>`and List<Rectangle>.
     * <p>
     * ? super Type - a wildcard with a lower bound. It stands for the family of all types that are supertypes of  Type ,
     * type  Type being included. Has to extend a specific type.
     * you cannot read elements to collection, only add them.(contra-variance)
     */
    public void testCoVariance(List<? extends Shape> list) {
        list.add(new Shape()); // does not compile
        list.add(new Circle()); // does not compile
        list.add(new Square()); // does not compile
        list.add(new Rectangle()); // does not compile
        Shape shape = list.get(0);//compiles
    }


    /**
     * Example for  a lower bound wildcard
     * We can not safely get, because we may have  `List<Circle>`, `List<Square>`and List<Rectangle>.
     */
    public void testContraVariance(List<? super Shape> list) {
        list.add(new Shape());//compiles
        list.add(new Circle());//compiles
        list.add(new Square());//compiles
        list.add(new Rectangle());//compiles
        Shape shape = list.get(0); // does not compile
    }
}
