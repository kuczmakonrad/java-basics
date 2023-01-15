package pl.kuczdev.__work_questions.oop_javablog;
/*
Introduction
Abstraction is a concept of exposing only essential details and hiding implementation details.
It is one of the essential OOPs concept apart from encapsulation, inheritance and polymorphism.
Abstraction retains only information which is most relevant for the specific purpose.

For example:

ArrayList stores objects in sequential manner as list and you can use add() method to add elements to ArrayList, remove() method to remove elements from it,
and get() method to retrieve element from the ArrayList.
That’s all you need to know to use ArrayList. That’s abstraction in java.

If you want to use ArrayList, you don’t need to understand how ArrayList works internally.
ArrayList uses abstraction by implementing List interface and List interface provides all necessary methods to use ArrayList.
so you can declare ArrayList as below:

    List<String> list = new ArrayList<>();

    list.add("Java");
    list.add("Python");
    list.add("C++");

    list.remove("Python");

    String python = list.get(1);

and call add(), remove() and get methods of List interface.

Suppose you realized later that you need to use LinkedList rather than ArrayList as you need to perform more add and remove operations rather than access operations.
You can go through ArrayList vs LinkedList to understand the differences between them.

You just need to change declaration line.

    List<String> list = new LinkedList<>();

    list.add("Java");
    list.add("Python");
    list.add("C++");

    list.remove("Python");
    String python = list.get(1);

ArrayList and LinkedList use abstraction by implementing List interface that’s why we are able to replace ArrayList with LinkedList in above example.
Let’s take another real life example.

When you search for any text on google, you just type text in text area and click on search button.
What happens behind the scenes, how google search algorithm works, you might not be aware of that.

Ways to achieve abstraction
You can achieve abstraction using two ways in java.
    1. Abstract class(0 to 100% abstraction)
    2. Interface (100% abstraction)

Abstract class in java:
    An abstract class is the class which is declared abstract and can have abstract or non abstract methods.
    It should be extended by child class and should implement abstract method.


Abstract method in java:
Abstract method is the method which do not have implementation i.e. it does not have any body.

    abstract class Shape{
        public abstract double calculateArea();  // No body for calculatedArea method
    }

Interface in java
Interface is generally used to provide contract for class to implement.
Interface do not have implementation of any method.A class implements an interface, thereby inheriting the abstract methods of the interface.
So it is kind of signing a contract, you agree that if you implement this interface, then you have to use its methods.It is just a pattern,
it can not do anything itself.

    interface Paintable {
       void paint();
    }

    public class Room implements Paintable{

        @Override
        public void paint() {
            System.out.println("Painting the room");
        }
    }


Abstraction vs Encapsulation
Encapsulation is process of binding related data(variables and methods) into a class.We can achieve encapsulation using access modifers such
as public, private, protected.

Encapsulation is implementation of desired abstraction.
Abstraction is more of design level concept and helps you to provide only essential details and hiding implementation details.
We can achieve abstraction by abstract class and interface.


Lets say we have Sport as interface.
Now it’s implementation will be provided by classes called “Cricket” and “Football”.
In real scenario, end user will not aware of implementation class and object of implementation class can be provided by factory method.
Factory method can be used to create object of implementation class based on some criterion.
Let’s create an interface called Sport.java.
*/

interface Sport {
    void play();
}

class Cricket implements Sport {
    @Override
    public void play() {
        System.out.println("Playing cricket");
    }
}

class Football implements Sport {
    @Override
    public void play() {
        System.out.println("Playing football");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        // In real scenario, you will get concrete object using getSport() factory method
        Sport sport = new Cricket();
        sport.play();

        System.out.println("=================");

        // You can easily change implementation
        sport=new Football();
        sport.play();
    }
}
