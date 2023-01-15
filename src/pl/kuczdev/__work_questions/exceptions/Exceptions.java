package pl.kuczdev.__work_questions.exceptions;
/*
Flow of the program will be as below.
    Value of variable i will be set to 6.
    NullPointerException will be thrown from try block.
    Flow will go to catch block and value of i will be set to 10. JVM will make note of value of i and this will be returned by exceptionTest method.
    Before returning from exceptionTest method, finally block will be executed and “In finally block” will be printed on console.
    In the end, return value of exceptionTest method will be 10.
 */

public class Exceptions {
    public static void main(String[] args) {
        System.out.println(exceptionTest());
    }

    public static int exceptionTest() {
        int i = 6;
        try {
            throw new NullPointerException();
        } catch(Exception e) {
            i = 10;
            return i;
        } finally {
            i = 20;
            System.out.println("In finally block");
        }
    }
}

