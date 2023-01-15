package pl.kuczdev.__work_questions.oop_javablog.abstract_class_and_interface_and_differences;
/*
In this post, I will introduce default methods in interface which are introduced in  Java 8.

Have you ever faced a situation, when you created an interface and many classes implemented that interface.
Now you need to add new methods to interface.
After adding new methods, your java project will be full of compilation errors because you need to add these new methods to all classes which are implementing
that interface (If a class implement an interface then you have to implement all its methods in the class).

As you can see,
we have made decorateWithPaints() default and we will not get any error in Room class as we have provided default implementation in Decorable interface.

Why default methods:
The oneliner for this could be “backward compatibility”.If JDK modifies an interface, then all classes which implements this interface will break.

For adding lambda expression in Java 8, JDK needs to add  methods(such as foreach) to List or collections Interface,
but if you add this method to these interface, it will break millions lines of code as class which implements the interface, need to implement all its methods.

By adding default method in interface,
you can provide default implementation of it without affecting implementing classes as it includes implementation of that method
and any implementing class which needs that method can override it.


What about multiple Inheritance?
Adding default implementation to the interface can give rise to ambiguity in multiple inheritance.
As two interface can provide same default method and there can be ambiguity while calling.
Java 8 will give you compile time exception when this kind of situation will arise.
so it will give you compile time error

        public interface Decorable {
            default void decorateWithPaints(){
               System.out.println("Decorate using paints");
            }
        }

        public interface Paintable {
            default void decorateWithPaints() {
                System.out.println("Decorate using paints");
            }
        }

        public class Room implements Decorable,Paintable{}


you can solve this compilation error by overriding decorateWithPaints method in Room class

    public class Room implements Decorable,Paintable {
        public void decorateWithPaints() {
            System.out.println("Decorate using paints");
        }
    }


*/

interface Decorable {
    void decorateWithCurtains();

    default void decorateWithPaints() {
        System.out.println("Decorate using paints");
    }
}

class Room2 implements Decorable {
    public void decorateWithCurtains() {
        System.out.println("Decorate room with Curtains");
    }
}

public class q03_InterfaceDefaultMethods {
}
