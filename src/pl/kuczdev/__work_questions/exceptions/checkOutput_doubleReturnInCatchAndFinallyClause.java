package pl.kuczdev.__work_questions.exceptions;
/*
In finally block
20

Flow of the program will be as below.
    Value of variable i will be set to 6.
    Value of variable i will be set to 10 and JVM will make note of return value of i as 10.
    finally will get excuted and value of i will be set to 20.”In finally block” will be printed on console.
    In the end, return value of exceptionTest method will be 20. It will override value returned by try block.
 */
public class checkOutput_doubleReturnInCatchAndFinallyClause {
    public static void main(String[] args) {
        System.out.println(exceptionTest());
    }
    public static int exceptionTest() {
        int i = 6;
        try {
            i = 50;
            return i;
        } finally {
            i = 20;
            System.out.println("In finally block");
            return i;
        }
    }
}