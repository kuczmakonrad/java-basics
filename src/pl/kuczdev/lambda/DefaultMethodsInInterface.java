package pl.kuczdev.lambda;

import java.sql.SQLOutput;

@FunctionalInterface
interface MathInterface {
    int operate(int a, int b);

    default int add(int a, int b) {
        return a + b;
    }

    default int substract(int a, int b) {
        return a - b;
    }

    default int multiply(int a, int b) {
        return a * b;
    }

    static int divide(int a, int b) {
        return a / b;
    }
}

class MathClass implements MathInterface {

    @Override
    public int operate(int a, int b) {
        System.out.println("MathClass.operate()");
        return a + b;
    }

    @Override
    public int multiply(int a, int b) {
        System.out.println("MathClass.multiply()");
        return a * b;
    }

    @Override
    public int add(int a, int b) {
        System.out.println("MathClass.add()");
        return MathInterface.super.add(a, b);
    }
}

public class DefaultMethodsInInterface {
    public static void main(String[] args) {
        MathInterface math = (int a, int b) -> a * b;
        System.out.println(math.operate(10,30));    // OUTPUT: 300
        System.out.println(math.add(10,15));        // OUTPUT: 25
        System.out.println(MathInterface.divide(100,25));    // OUTPUT: 4

        MathClass mathClass = new MathClass();
        System.out.println(mathClass.operate(100,100));     //OUTPUT: MathClass.operate() 200
        System.out.println(mathClass.multiply(100, 5));     //OUTPUT: MathClass.multiply() 500
        System.out.println(mathClass.substract(300, 150));  //OUTPUT: 150
        System.out.println(mathClass.add(100,300));         // OUTPUT: MathClass.add() 400

    }
}
