package pl.kuczdev.__code_questions.q15_arrays_find_number_occuring_odd_number_of_times_in_an_array;

// brute force solution for this problem but it takes o(n*n) time complexity.

public class NumberOccuringOddNumberInArrayByTwoLoops {
    public static void main(String[] args) {
        int[] test = new int[]{20,40,50,40,50,20,30,30,50,20,40,40,20};
        System.out.println("In testArray you can see triple 50 and this is correct answer. ANSWER = " + findNumberOccuringOddNumberInArrayByTwoLoops(test));
        int[] test2 = new int[]{1,2,3,4,5,1,2,3,4,5,9};
        System.out.println("In testArray2 you can see once 9 and this is correct answer. ANSWER = " + findNumberOccuringOddNumberInArrayByTwoLoops(test2));
        int[] test3 = new int[]{100,100,100,100,200,200,200,200,300,300,300,300,1};
        System.out.println("In testArray3 you can see once 1 and this is correct answer. ANSWER = " + findNumberOccuringOddNumberInArrayByTwoLoops(test3));

    }

    private static int findNumberOccuringOddNumberInArrayByTwoLoops(int[] arr) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            counter = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) counter++;
            }
            if (counter%2!=0) return arr[i];
        }

        return -1;
    }
}
