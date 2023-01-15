package pl.kuczdev.oop_basics.exceptions;

class TestException extends Exception {
    public TestException() {
       super("TestException Happends!");
    }

    public TestException(String errorMessage) {
        super(errorMessage);
    }
}

public class ThrowException {
    public int divide(int number, int divisor) throws ArithmeticException {
        return number/divisor;
    }

    public int test(int number) throws TestException {
        if (1 == 1) throw new TestException();
        return 1;
    }

    public static void main(String[] args) {
        try {
            int numArr[] = {0, 1, 2, 3, 4, 5};
            int a = numArr[2];
            int divisor = numArr[0];

            if (divisor == 0) throw new ArithmeticException("Dzielenie przez zero!");

        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally block always there if error or not!");
        }

        System.out.println("Program continues ----------------------");

        ThrowException throwException = new ThrowException();

        try {
            throwException.divide(10, 0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally block always there if error or not!!!!!");
        }

        System.out.println("Program STILL continues --------------------------");


        try {
            throwException.test(12);
        } catch (TestException e) {
            e.printStackTrace();
        }
    }
}