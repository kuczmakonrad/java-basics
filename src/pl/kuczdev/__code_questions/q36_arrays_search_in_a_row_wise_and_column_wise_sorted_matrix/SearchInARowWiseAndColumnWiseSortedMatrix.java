package pl.kuczdev.__code_questions.q36_arrays_search_in_a_row_wise_and_column_wise_sorted_matrix;
/*
Problem:
    Given row wise and column wise sorted matrix ,we need to search element with minimum time complexity.

Solution 1: Time complexity: O(R*C) complexity.
    You can simply search an element in 2D matrix.

Solution 2: Time complexity: O(C*logR).
    Iterate over each row
    Do binary search on rows unless you find the element.
    If you do not find the element , return false.


Solution 3: Time complexity : O(R+C).
We will use below logic to search an element:
    1. Elements right to current element will be greater than element
    2. Elements left to current element will be lesser than element
    3. Elements down to current element will be greater than element
    4. Elements top to current element will be lesser than element
Algorithm:
    1. Starts with top right element, so initialise r=0 and c=
    2. sortedMatrix[0].length-1
    3. Iterate over matrix with boundary conditions.
    4. If current element lets say m is equal to element X, return it.
    5. If m < X, go left,so decrease column by 1 (c--).
    6. If m > X, go right, so increase row by 1(r++).
*/

public class SearchInARowWiseAndColumnWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] sortedMatrix =
                {
                        { 1, 6, 10, 12, 20 },
                        { 4, 8, 15, 22, 25 },
                        { 5, 20, 35, 37, 40 },
                        { 10, 28, 38, 45, 55 }
                };

        searchElementInSortedMatrix(sortedMatrix, 37);
    }

    private static void searchElementInSortedMatrix(int[][] sortedMatrix, int X) {
        int R = sortedMatrix.length;
        int C = sortedMatrix[0].length;
        int r = 0, c = C - 1;

        // We can go either left or down
        // left => decrement in columns, 0 will be the bound
        // down => increment in row, R-1 will be the bound
        while (r <= R - 1 && c >= 0) {
            if (sortedMatrix[r][c] == X) { // Found the element
                System.out.println("Element found at r =" + r + " c=" + c);
                return;
            }
            if (X < sortedMatrix[r][c]) { // move left
                c = c - 1;
            } else { // move down
                r = r + 1;
            }
        }
        System.out.println("Element is not found in sorted matrix");
    }
}
