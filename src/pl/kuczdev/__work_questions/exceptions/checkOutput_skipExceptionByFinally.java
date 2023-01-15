package pl.kuczdev.__work_questions.exceptions;
/*
In finally block
20

Flow of the program will be as below.
    Value of variable i will be set to 6.
    NullPointerException will be thrown from try block.
    Flow will go to catch block and value of i will be set to 10. We are throwing NullPointerException from catch block.
    finally will get excuted and value of i will be set to 20.”In finally block” will be printed on console.
    In the end, return value of exceptionTest method will be 20.
    If you notice here, return statement from finally block actually suppressed the NullPointerException.
 */
public class checkOutput_skipExceptionByFinally {
    public static void main(String[] args) {
        System.out.println(exceptionTest());
    }
    public static int exceptionTest() {
        int i = 6;
        try {
            throw new NullPointerException();
        } catch(NullPointerException e) {
            i = 10;
            throw e;
        } finally {
            i = 20;
            System.out.println("In finally block");
            return i;
        }
    }
}
