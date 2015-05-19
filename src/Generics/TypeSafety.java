package Generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by cnkaptan on 4/28/15.
 */
public class TypeSafety {

    public static void main(String[] args){
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("John Doe"));
        employees.add(new Employee("Jane Smith"));
        Iterator<Employee> iter = employees.iterator();
        while (iter.hasNext())
        {
            Employee emp = iter.next();
            System.out.println(emp.getName());
        }
    }
}

class Employee
{
    private String name;
    Employee(String name)
    {
        this.name = name;
    }
    String getName()
    {
        return name;
    }
}
