package pl.kuczdev.__work_questions.fibonacci;
/*
Initialise first two terms with 0 and 1
Base case will be when numberOfElements becomes 0.
Find sum of first two terms.
Print the sum
Assign prev to next and next to sum to go for next two terms.
Call same function again and decrease numberOfElements.
 */
public class FibbonaciViaRecursion {
    static int first = 0;
    static int second = 1;
    static int current = 1;

    public static void main(String[] args) {
        System.out.print(first + " " + second);
        getRestFibonacciToElementToIndex(15);
    }

    private static void getRestFibonacciToElementToIndex(int max) {
        if (max == 0) {
            return;
        } else {
            current = first + second;
            System.out.print(" " + current);

            first = second;
            second = current;

            getRestFibonacciToElementToIndex(max-1);
        }
    }
}
