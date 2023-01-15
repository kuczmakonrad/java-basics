package pl.kuczdev.__work_questions.oop_javablog.abstract_class_and_interface_and_differences;
/*
In previous post, we have seen abstract class in java which provides partial abstraction.
Interface is one of the core part of java and is used to achieve full abstraction.
Interface is generally used to provide contract for class to implement.
Interface do not have implementation of any method.
A class implements an interface, thereby inheriting the abstract methods of the interface.
So it is kind of signing a contract, you agree that if you implement this interface, then you have to use its methods.
It is just a pattern, it can not do anything itself.

All the methods in the interface are by default public and abstract and all variables are public static final.

    interface InterfaceName {
       void method1();
       int method2();
    }

For example:
Let’s say you have Room class as your pojo class.
Now you want all your rooms to be decorable, so you can just implement decorable interface and implement decorate method.

    interface Decorable {
       void decorate();
    }
    public class Room implements Decorable {
        @Override
        public void decorate() {
            System.out.println("Decorating the room");
        }
    }

Interface and inheritance:
You can create inheritance in terms of interface too. An interface can only extend(extends) another interface.

interface interface1 {
    void method1();
}

interface interface2 extends interface1 {
    void method2();
}

public class ConcreteClass implements interface2 {
    @Override
    public void method1() {
        System.out.println("In method 1");

    }

    @Override
    public void method2() {
        System.out.println("In method 2");
    }
}

Important points about interface in java:
    * You need to use “Interface” keyword to declare an interface.
    * An interface can not have any method implementation.
    * Interface methods are by default public abstract.
    * Interface variables are by default public static final.
    * implements keyword is used by class to use interface.
    * One interface can not extend another class bit can extend another interface using extends keyword.
    * A class needs to override all methods of interface unless it is abstract class, otherwise, you will get compilation errors.
    * You need to design interface very carefully, as once you have used in business logic, you won’t be able to remove or add methods from interface.

Example below:
*/

interface Room {
    void showRoom();
}

class SimpleRoom implements Room {
    @Override
    public void showRoom() {
        System.out.println("Showing simple room");
    }
}

class SpecialRoom implements Room {
    @Override
    public void showRoom() {
        System.out.println("Showing special Room");
    }
}

class RoomInterfaceMain {

    public static void main(String[] args) {

        // You can assign interface reference variable to concrete implementation
        Room room = new SimpleRoom();
        room.showRoom();

        System.out.println("=================");

        // You can easily change implementation
        room = new SpecialRoom();
        room.showRoom();
    }
}