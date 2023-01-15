package pl.kuczdev.__code_questions.q15_arrays_find_number_occuring_odd_number_of_times_in_an_array;

/*
You can do bitwise XOR operation for all elements and it will give you element which occurs odd numbers of times in the end.
This algoritm solves the problem with O(n) time complexity and O(1) space complexity and this is best solution for this problem.
 */

// Java program to find the element occuring odd numbers of times
public class NumberOccuringOddNumberInArrayByXOR {
    public static void main(String[] args) {
        int[] test = new int[]{20,40,50,40,50,20,30,30,50,20,40,40,20};
        System.out.println("In testArray you can see triple 50 and this is correct answer. ANSWER = " + findNumberOccuringOddNumberInArrayByXOR(test));
        int[] test2 = new int[]{1,2,3,4,5,1,2,3,4,5,9};
        System.out.println("In testArray2 you can see once 9 and this is correct answer. ANSWER = " + findNumberOccuringOddNumberInArrayByXOR(test2));
        int[] test3 = new int[]{100,100,100,100,200,200,200,200,300,300,300,300,1};
        System.out.println("In testArray3 you can see once 1 and this is correct answer. ANSWER = " + findNumberOccuringOddNumberInArrayByXOR(test3));
    }

    public static int findNumberOccuringOddNumberInArrayByXOR(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        return result;
    }
}
