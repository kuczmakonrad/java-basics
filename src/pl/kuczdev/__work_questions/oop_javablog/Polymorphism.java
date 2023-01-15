package pl.kuczdev.__work_questions.oop_javablog;
/*
Polymorphism means one name many forms. In Java, polymorphism can be achieved by method overloading and method overriding.

There are two types of polymorphism in java.
    * Compile time polymorphism.
    * Run time polymorphism.


Compile time Polymorphism:
    Compile time Polymorphism is nothing but method overloading in java.
    You can define various methods with same name but different method arguments.
    You can read more about method overloading.

Let’s understand with the help of example:

    public class MethodOverloadingExample {
        public void method1(int a)
        {
            System.out.println("Integer: "+a);
        }
        public void method1(double b)
        {
            System.out.println("Double "+b);
        }
        public void method1(int a, int b)
        {
            System.out.println("Integer a and b:"+a+" "+b);
        }
        public static void main(String args[])
        {
            MethodOverloadingExample moe=new MethodOverloadingExample();
            moe.method1(20);
            moe.method1(30.0);
            moe.method1(20, 30);
        }
    }

OUTPUT:
Integer: 20
Double 30.0
Integer a and b:20 30

As you can see here, we have used same method name but different method arguments.The compiler will call appropriate method based on best-matched arguments.


Runtime Polymorphism:
Runtime Polymorphism is nothing but method overriding in java.If subclass is having same method as base class then it is known as method overriding Or
in another word, If subclass provides specific implementation to any method which is present in its one of parents classes then it is known as method overriding.
Let’s say you have parent class as Shape and child class as Rectangle and circle.

    public class Shape {
        public void draw() {
            System.out.println("Drawing Shape");
        }
        public static void main(String[] args) {
            Shape s=new Rectangle();
            s.draw();

            s=new Circle();
            s.draw();
        }
    }

    class Rectangle extends Shape {
        public void draw() {
            System.out.println("Drawing Rectangle");
        }
    }

    class Circle extends Shape {
        public void draw() {
            System.out.println("Drawing Circle");
        }
    }

OUTPUT:
    Drawing Rectangle
    Drawing Circle

Please note that we are assigning child object to parent object here.
    Shape s=new Rectangle();

As you can see we have overridden draw methods in child class Rectangle and Circle.
JVM decides at runtime which method it needs to call depending on the object assignment. That’s why this is known as Run time polymorphism.
*/

class Shape {
    public void draw() {
        System.out.println("Drawing Shape");
    }
}

class Rectangle extends Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class Circle extends Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        // 1. Compile Polimorphism.
        Polymorphism poly = new Polymorphism();
        poly.show(20);
        poly.show(30.0);
        poly.show(20, 30);

        // 2. Runtime Polymorphism.
        Shape s = new Rectangle();
        s.draw();

        s = new Circle();
        s.draw();
    }

    public void show(int a) {
        System.out.println("Integer: " + a);
    }

    public void show(double b) {
        System.out.println("Double " + b);
    }

    public void show(int a, int b) {
        System.out.println("Integer a and b:" + a + " " + b);
    }
}