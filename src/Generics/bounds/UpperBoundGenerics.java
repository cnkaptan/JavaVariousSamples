package Generics.bounds;

/**
 * Created by cnkaptan on 4/28/15.
 */
public class UpperBoundGenerics {
    public static void main(String[] args)
    {
        SortedShapeList<Circle> ssl = new SortedShapeList<Circle>();
        ssl.add(new Circle(100, 200, 300));
        ssl.add(new Circle(10, 20, 30));
    }
}

abstract class Shape{

}

class Circle extends Shape implements Comparable<Circle>{
    private double x, y, radius;
    Circle(double x, double y, double radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public int compareTo(Circle circle) {
        if (radius < circle.radius)
            return -1;
        else if (radius > circle.radius)
            return 1;
        else
            return 0;
    }
    @Override
    public String toString()
    {
        return "(" + x + ", " + y + ", " + radius + ")";
    }

}


class SortedShapeList<S extends Shape & Comparable<S>>{
    private S[] shapes = (S[]) new Shape[2];
    private int index = 0;

    void add(S shape)
    {
        shapes[index++] = shape;
        if (index < 2)
            return;
        System.out.println("Before sort: " + this);
        sort();
        System.out.println("After sort: " + this);
    }

    private void sort()
    {
        if (index == 1)
            return;
        if (shapes[0].compareTo(shapes[1]) > 0)
        {
            S shape = (S) shapes[0];
            shapes[0] = shapes[1];
            shapes[1] = shape;
        }
    }

    @Override
    public String toString()
    {
        return shapes[0].toString() + " " + shapes[1].toString();
    }
}

