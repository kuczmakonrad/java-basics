package pl.kuczdev.__work_questions.oop_javablog.abstract_class_and_interface_and_differences;
/*
An abstract class is the class which is declared abstract and can have abstract or non abstract methods.
An abstract class can not be instantiated. It can be extended by subclass to implement abstract methods and either use or override concrete methods.


Abstract method in java:
    Abstract method is the method which do not have implementation i.e. it does not have anybody.

        abstract class Shape {
            public abstract double calculateArea();
        }


When do you need abstract class in java?
    Let’s understand it with the help of the example.
    You have Shape class and it has some methods such as draw(), calcualteArea() etc.
    Drawing a shape is common for all the shapes but calculateArea() is different for each shape.

For example:
    For Rectangle, it will be calculated as length * breadth and for circle, it will be pi* radius^2.
    So with above behavior, we will implement draw() method in shape class and will create calcualteArea() as abstract method.
    So if you have some common behaviors and some specific behavior, make your class abstract.

Let’s create a abstract class as Shape and Rectangle, Circle class as concrete classes.

 */
public class q01_AbstractClass {
}
