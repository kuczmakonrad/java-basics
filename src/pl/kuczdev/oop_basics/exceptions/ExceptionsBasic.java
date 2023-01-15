package pl.kuczdev.oop_basics.exceptions;

public class ExceptionsBasic {
    public static void main(String[] args) {
        try {
            int numArr[] = {0,1,2,3,4,5};
            int a = numArr[12];                         // tablica numArr[] nie ma indeksu 12 - więc wywoła się błąd (dokładny) - ArrayindexOutOfBoundException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundException <- System.out.println()");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Można robić wiele bloków catch z różnymi exceptionami - w niektórych sytuacjach może to być przydatne, a w niektórych można zastosować błąd ogólny Exception");
        } finally {
            System.out.println("Finally block always there if error or not!");
        }

        System.out.println("Program continues ----------------------");

        try {
            int numArr[] = {0,1,2,3,4,5};
            int a = numArr[2] / numArr[0];              // nie można dzielić przez zero - więc wywoła się błąd (dokładny) - ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException <- System.out.println()");
            e.printStackTrace();
        } finally {
            System.out.println("Finally block always there if error or not!!!!!");
        }

        System.out.println("Program STILL continues --------------------------");

        try {
            int numArr[] = {0,1,2,3,4,5};
            int a = numArr[2] / numArr[0];              // nie można dzielić przez zero - więc wywoła się błąd (niedokładny) - Exception
        } catch (Exception e) {
            System.out.println("Exception <- System.out.println()");
            e.printStackTrace();
        } finally {
            System.out.println("Finally block always there if error or not!!!!!!!!!!!!!!!!!");
        }

        System.out.println("Program STILL continues --------------------------");
    }
}
