package pl.kuczdev.__work_questions.fibonacci;
/*
    Initialise first two terms with 0 and 1
    Find sum of first two terms.
    Iterate upto numberOfElements
    Print the sum
    Assign prev to next and next to sum to go for next two terms.
 */
public class FibonacciViaIteration {
    public static void main(String[] args) {
        int prev = 0, next = 1;                     // declare first two elements
        int numbersOfElementsToPrint = 10;          // numbers of element to print

        System.out.println("Fibbonaci for " + numbersOfElementsToPrint + " elements:");
        System.out.print(prev + " " + next);      // printing first two elements

        int sum = 0;
        for (int i = 2; i < numbersOfElementsToPrint; i++) {
            sum = prev + next;
            System.out.print(" " + sum);          // add next element to show

            prev = next;
            next = sum;
        }
    }
}
