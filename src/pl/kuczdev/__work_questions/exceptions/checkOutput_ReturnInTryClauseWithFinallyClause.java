package pl.kuczdev.__work_questions.exceptions;
/*
In finally block
6

Explanation:
If you notice we have return statement in try block, so before returning from exceptionTest() method, finally block will be executed.
When you have return statement in try block, JVM will take note of value of i and this value will be returned by exceptionTest method.
 */
public class checkOutput_ReturnInTryClauseWithFinallyClause {
    public static void main(String[] args) {
        System.out.println(exceptionTest());
    }
    public static int exceptionTest(){
        int i = 6;

        try {
            return i;
        }
        catch(Exception e) {
            i=10;
        }
        finally {
            System.out.println("In finally block");
        }

        return i;
    }
}
